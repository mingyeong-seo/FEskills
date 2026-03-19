import { useNavigate, useParams } from "react-router-dom";
import ModifyComponent from "../../components/ModifyComponent";

const ModifyPage = () => {
  const navigate = useNavigate();
  const { tno } = useParams();

  const moveToRead = () => {
    navigate(`/todo/read/${tno}`);
  };

  const moveToList = () => {
    navigate("/todo/list");
  };

  return (
    <div className="text-3xl font-extrabold">
      Todo Modify Page
      <ModifyComponent
        tno={tno}
        moveToList={moveToList}
        moveToRead={moveToRead}
      />
    </div>
  );
};

export default ModifyPage;
