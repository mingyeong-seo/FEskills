import { Cookies } from "react-cookie";

const cookies = new Cookies();

export const setCookie = (name, value, days) => {
  const expires = new Date();
  expires.setUTCDate(expires.getDate() + days);
  return cookies.set(name, value, { path: "/", expires });
};

export const getCookie = (name) => {
  return cookies.get(name);
};

export const removeCookies = (name, path = "/") => {
  console.log("removeCookies 실행:", name);
  cookies.remove(name, { path });
};
