import axios from "axios";
import { getCookie } from "./cookieUtils";

// 백단 서버에 쿠키 정보를 전달 하도록 구현함
const jwtAxios = axios.create();

// 요청 이전작업
const beforeReq = (config) => {
  console.log("before request..");

  const memberInfo = getCookie("member");
  if (!memberInfo) {
    console.log("Member Not Found");
    return Promise.reject({
      response: {
        data: {
          error: "REQUIRE_LOGIN",
        },
      },
    });
  }

  const { accessToken } = memberInfo;
  console.log("!!!!!!!" + accessToken);
  config.headers.Authorization = `Bearer ${accessToken}`;

  return config;
};

// 요청 실패
const requestFail = (err) => {
  console.log("요청 에러");
  return Promise.reject(err);
};

// 응답
const beforeRes = async (res) => {
  console.log("before response return...");
  return res;
};

// 응답 실패
const responseFail = (err) => {
  console.log("응답 실패");
  return Promise.reject(err);
};

jwtAxios.interceptors.request.use(beforeReq, requestFail);
jwtAxios.interceptors.response.use(beforeRes, responseFail);

export default jwtAxios;
