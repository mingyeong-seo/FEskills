// 백단 서버와 ajax 통신을 할 수 있는 모듈을 설계한다
// 먼저, 하나의 Todo 항목과 List를 얻어내도록 요청한다

import axios from "axios";

// 하나의 모듈에서 여러개의 컴포넌트를 export 할 때는 "export 컴포넌트명" 으로 정의한다
export const API_SERVER_HOST = "http://localhost";
const prefix = `${API_SERVER_HOST}/api/todo`;
export const getOne = async (tno) => {
  // 글 번호 tno를 받아서 ajax로 백단 서버에 데이터요청한다
  // 이때 사용하는 api가 axio.get, post, put 등의 메서드이다
  // async를 사용했기 때문에 반드시 await 를 통해 서버에 요청을 하고, 결과를 받아낸다.
  const res = await axios.get(`${prefix}/${tno}`);

  return res.data;
};

export const getList = async (pageParam) => {
  const { page, size } = pageParam;

  const res = await axios.get(`${prefix}/list`, {
    params: { page: page, size: size },
  });

  return res.data;
};
