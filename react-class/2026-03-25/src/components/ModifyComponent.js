import { useEffect, useState } from "react";
import { deleteOne, getOne, putOne } from "../api/todoApi";
import ResultModal from "./common/ResultModal";
import useCustomMove from "../hooks/useCustomMove";

const initState = {
  tno: 0,
  title: "",
  writer: "",
  dueDate: "",
  complete: false,
};

const ModifyComponent = ({ tno }) => {
  const [todo, setTodo] = useState({ ...initState });

  // 모달
  const [result, setResult] = useState(null);
  const { moveToList, moveToRead } = useCustomMove();

  useEffect(() => {
    console.log("tno: " + tno);
    if (!tno) return;

    console.log("조회할 tno:", tno);

    getOne(tno)
      .then((data) => {
        console.log("조회 결과:", data);
        setTodo(data);
      })
      .catch((e) => {
        console.log("조회 에러:", e);
      });
  }, [tno]);

  const handleChangeTodo = (e) => {
    const { name, value } = e.target;

    setTodo({
      ...todo,
      [name]: value,
    });
  };

  const handleChangeTodoComplete = (e) => {
    const value = e.target.value;

    setTodo({
      ...todo,
      complete: value === "true",
    });
  };

  const closeModal = () => {
    setResult(null);
    moveToList();
  };

  const handleClickModify = () => {
    putOne(todo)
      .then((data) => {
        console.log("수정 결과:", data);
        setResult("Modifed");
      })
      .catch((e) => {
        console.log("수정 에러:", e);
      });
  };

  const handleClickDelete = () => {
    deleteOne(tno)
      .then((data) => {
        console.log("삭제 결과:", data);
        setResult("Deleted");
      })
      .catch((e) => {
        console.log("삭제 에러:", e);
      });
  };

  return (
    <div className="border-2 border-sky-200 mt-10 m-2 p-4">
      {result ? (
        <ResultModal
          title={"처리 결과"}
          content={result}
          callbackFn={closeModal}
        />
      ) : null}
      <div className="flex justify-center mt-10">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-1/5 p-6 text-right font-bold">TNO</div>
          <div className="w-4/5 p-6 rounded-r border border-solid shadow-md bg-gray-200">
            {todo.tno}
          </div>
        </div>
      </div>

      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-1/5 p-6 text-right font-bold">WRITER</div>
          <div className="w-4/5 p-6 rounded-r border border-solid shadow-md bg-gray-200">
            {todo.writer}
          </div>
        </div>
      </div>

      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-1/5 p-6 text-right font-bold">TITLE</div>
          <input
            className="w-4/5 p-6 rounded-r border border-solid border-neutral-300 shadow-md"
            name="title"
            type="text"
            value={todo.title}
            onChange={handleChangeTodo}
          />
        </div>
      </div>

      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-1/5 p-6 text-right font-bold">DUEDATE</div>
          <input
            className="w-4/5 p-6 rounded-r border border-solid border-neutral-300 shadow-md"
            name="dueDate"
            type="date"
            value={todo.dueDate || ""}
            onChange={handleChangeTodo}
          />
        </div>
      </div>

      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-1/5 p-6 text-right font-bold">COMPLETE</div>
          <select
            name="complete"
            className="border-solid border-2 rounded m-1 p-2"
            onChange={handleChangeTodoComplete}
            value={todo.complete ? "true" : "false"}
          >
            <option value="true">Completed</option>
            <option value="false">Not Yet</option>
          </select>
        </div>
      </div>

      <div className="flex justify-end p-4">
        <button
          type="button"
          className="inline-block rounded p-4 m-2 text-xl w-32 text-white bg-red-500"
          onClick={handleClickDelete}
        >
          Delete
        </button>
        <button
          type="button"
          className="rounded p-4 m-2 text-xl w-32 text-white bg-blue-500"
          onClick={handleClickModify}
        >
          Modify 완료
        </button>
      </div>
    </div>
  );
};

export default ModifyComponent;
