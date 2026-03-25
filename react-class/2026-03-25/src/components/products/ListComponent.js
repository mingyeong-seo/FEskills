import { useEffect, useState } from "react";
import useCustomMove from "../../hooks/useCustomMove";
import FetchingModal from "../common/FetchingModal";
import { getList } from "../../api/productsApi";
import { API_SERVER_HOST } from "../../api/todoApi";
import PageComponent from "../common/PageComponent";

const initState = {
  dtoList: [],
  pageNumList: [],
  pageRequestDTO: null,
  prev: false,
  prevPage: 0,
  nextPage: 0,
  next: false,
  totalCount: 0,
  current: 0,
};

const ListComponent = () => {
  const host = API_SERVER_HOST;
  const { page, size, moveToList, moveToRead } = useCustomMove();
  const [serverData, setServerData] = useState(initState);
  const [fetching, setFetching] = useState(false);

  useEffect(() => {
    setFetching(true);
    getList({ page, size }).then((data) => {
      console.log(data);
      setServerData(data);
      setFetching(false);
    });
  }, [page, size]);

  return (
    <div className="border-2 border-blue-100 mt-10 mr-2 ml-2">
      <h1>Products List Component</h1>

      {fetching ? <FetchingModal /> : null}
      {serverData.dtoList.map((product) => (
        <div
          key={product.pno}
          className="w-1/2 p-1 rounded shadow-md border-2"
          onClick={() => moveToRead(product.pno)}
        >
          <div className="flex flex-col h-full">
            {/* 상품 번호 */}
            <div className="font-extrabold text-2xl p-2 w-full">
              {product.pno}
            </div>

            <div className="text-xl m-1 p-2 w-full flex flex-col">
              {/* 상품 이미지 */}
              <div className="w-full overflow-hidden">
                <img
                  alt={product.pname}
                  className="m-auto rounded-md w-60"
                  src={`${host}/api/products/view/${product.uploadFileNames[0]}`}
                />
              </div>

              {/* 상품 정보 */}
              <div className="bottom-0 font-extrabold bg-white">
                <div className="text-center p-1">이름: {product.pname}</div>
                <div className="text-center p-1">가격: {product.price}</div>
              </div>
            </div>
          </div>
        </div>
      ))}
      <PageComponent serverData={serverData} movePage={moveToList} />
    </div>
  );
};

export default ListComponent;
