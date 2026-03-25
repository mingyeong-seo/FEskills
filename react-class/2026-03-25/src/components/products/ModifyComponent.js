import { useEffect, useRef, useState } from "react";
import { getOne, putProduct } from "../../api/productsApi";
import FetchingModal from "../common/FetchingModal";
import { API_SERVER_HOST } from "../../api/todoApi";
import useCustomMove from "../../hooks/useCustomMove";
import ResultModal from "../common/ResultModal";
import { deleteProduct } from "../../api/productsApi";

const initState = {
  pno: 0,
  pname: "",
  pdesc: "",
  price: 0,
  uploadFileNames: [],
};

const host = API_SERVER_HOST;

const ModifyComponent = ({ pno }) => {
  const [product, setProduct] = useState(initState);
  const [fetching, setFetching] = useState(false);
  const [result, setResult] = useState(null);
  const uploadRef = useRef();
  const { moveToList } = useCustomMove();

  useEffect(() => {
    setFetching(true);

    getOne(pno).then((data) => {
      setProduct(data);
      setFetching(false);
    });
  }, [pno]);

  const handleChangeProduct = (e) => {
    product[e.target.name] = e.target.value;
    setProduct({ ...product });
  };

  const deleteOldImages = (imageName) => {
    const resultFileNames = product.uploadFileNames.filter(
      (fileName) => fileName != imageName,
    );

    product.uploadFileNames = resultFileNames;

    setProduct({ ...product });
  };

  const handleClickModify = () => {
    const files = uploadRef.current.files;
    const formData = new FormData();

    for (let i = 0; i < files.length; i++) {
      formData.append("files", files[i]);
    }

    formData.append("pname", product.pname);
    formData.append("pdesc", product.pdesc);
    formData.append("price", product.price);
    formData.append("delFlag", product.delFlag);

    for (let i = 0; i < product.uploadFileNames.length; i++) {
      formData.append("uploadFileNames", product.uploadFileNames[i]);
    }

    setFetching(true);

    putProduct(pno, formData).then((data) => {
      setFetching(false);
      setResult(pno);
    });
  };

  const handleClickDelete = async () => {
    setFetching(true);

    try {
      await deleteProduct(pno);
      moveToList({ page: 1 });
    } catch (e) {
      console.error("삭제 실패:", e);
    } finally {
      setFetching(false);
    }
  };

  const closeModal = () => {
    setResult(null);
    moveToList({ page: 1 });
  };
  return (
    <div className="border-2 border-sky-200 mt-10 m-2 p-4">
      {fetching ? <FetchingModal /> : <></>}
      {/*  결과 모달 처리,, 서버의 데이터가 존재하면 모달 띄움 */}
      {result ? (
        <ResultModal
          title={"상품 수정 결과"}
          content={`${result}번 수정 완료됨`}
          callbackFn={closeModal}
        />
      ) : (
        <></>
      )}
      <div className="border-2 border-sky-200 mt-10 m-2 p-4">
        {fetching ? <FetchingModal /> : null}

        <div className="flex justify-center mt-10">
          <div className="relative mb-4 flex w-full flex-wrap items-stretch">
            <div className="w-1/5 p-6 text-right font-bold">Product Name</div>
            <input
              className="w-4/5 p-6 rounded-r border border-solid border-neutral-300 shadow-md"
              name="pname"
              type="text"
              value={product.pname}
              onChange={handleChangeProduct}
            />
          </div>
        </div>

        <div className="flex justify-center">
          <div className="relative mb-4 flex w-full flex-wrap items-stretch">
            <div className="w-1/5 p-6 text-right font-bold">Desc</div>
            <textarea
              className="w-4/5 p-6 rounded-r border border-solid border-neutral-300 shadow-md resize-y"
              name="pdesc"
              rows="4"
              onChange={handleChangeProduct}
              value={product.pdesc}
            />
          </div>
        </div>

        <div className="flex justify-center">
          <div className="relative mb-4 flex w-full flex-wrap items-stretch">
            <div className="w-1/5 p-6 text-right font-bold">Price</div>
            <input
              className="w-4/5 p-6 rounded-r border border-solid border-neutral-300 shadow-md"
              name="price"
              type="number"
              value={product.price}
              onChange={handleChangeProduct}
            />
          </div>
        </div>

        <div className="flex justify-center">
          <div className="relative mb-4 flex w-full flex-wrap items-stretch">
            <div className="w-1/5 p-6 text-right font-bold">DELETE</div>
            <select
              name="delFlag"
              value={product.delFlag}
              onChange={handleChangeProduct}
              className="w-4/5 p-6 rounded-r border border-solid border-neutral-300 shadow-md"
            >
              <option value={false}>사용</option>
              <option value={true}>삭제</option>
            </select>
          </div>
        </div>

        <div className="flex justify-center">
          <div className="relative mb-4 flex w-full flex-wrap items-stretch">
            <div className="w-1/5 p-6 text-right font-bold">Files</div>
            <input
              ref={uploadRef}
              className="w-4/5 p-6 rounded-r border border-solid border-neutral-300 shadow-md"
              type="file"
              multiple={true}
            />
          </div>
        </div>

        <div className="flex justify-center">
          <div className="relative mb-4 flex w-full flex-wrap items-stretch">
            <div className="w-1/5 p-6 text-right font-bold">Images</div>
            <div className="w-4/5 justify-center flex flex-wrap items-start">
              {product.uploadFileNames.map((imgFile, i) => (
                <div
                  className="flex justify-center flex-col w-1/3 m-1 align-baseline"
                  key={i}
                >
                  <button
                    className="bg-blue-500 text-3xl text-white"
                    onClick={() => deleteOldImages(imgFile)}
                  >
                    DELETE
                  </button>
                  <img
                    alt="img"
                    src={`${host}/api/products/view/s_${imgFile}`}
                  />
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
      <div className="flex justify-end p-4">
        {/* Delete 버튼 */}
        <button
          type="button"
          onClick={handleClickDelete}
          className="rounded p-4 m-2 text-xl w-32 text-white bg-red-500"
        >
          Delete
        </button>

        {/* Modify 버튼 */}
        <button
          type="button"
          onClick={handleClickModify}
          className="inline-block rounded p-4 m-2 text-xl w-32 text-white bg-orange-500"
        >
          Modify
        </button>

        {/* List 버튼 */}
        <button
          type="button"
          onClick={() => moveToList()}
          className="rounded p-4 m-2 text-xl w-32 text-white bg-blue-500"
        >
          List
        </button>
      </div>
    </div>
  );
};

export default ModifyComponent;
