import { useState } from "react";
import { useDispatch } from "react-redux";
import { login, loginPostAsync } from "../../slice/loginSlice";
import { useNavigate } from "react-router-dom";
import KakaoLoginComponent from "./KakaoLoginComponent";
import useCustomLogin from "../../hooks/useCustomLogin";

const initState = {
  username: "",
  password: "",
};

const LoginComponent = () => {
  const [loginParam, setLoginParam] = useState({ ...initState });
  const { doLogin, moveToPath, isLogin, moveToLoginReturn } = useCustomLogin();

  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleChange = (e) => {
    loginParam[e.target.name] = e.target.value;
    setLoginParam({ ...loginParam });
  };

  const handleClickLogin = () => {
    doLogin(loginParam)
      .then((data) => {
        console.log(data);

        if (data.error) {
          alert("이메일과 패스워드를 확인하세요");
        } else {
          alert("로그인 성공..");
          moveToPath("/");
        }
      })
      .catch((err) => {
        console.log(err);
        alert("로그인 중 오류가 발생했습니다.");
      });
  };

  return (
    <div className="border-2 border-sky-200 mt-10 m-2 p-4">
      <div className="flex justify-center">
        <div className="text-4xl m-4 p-4 font-extrabold text-blue-500">
          Login Component
        </div>
      </div>

      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-2/5 p-6 text-right font-bold">Email</div>
          <input
            className="w-1/5 p-6 rounded-r border border-solid border-neutral-500 shadow-md"
            name="username"
            type="text"
            value={loginParam.username}
            onChange={handleChange}
          />
        </div>
      </div>

      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
          <div className="w-2/5 p-6 text-right font-bold">Password</div>
          <input
            className="w-1/5 p-6 rounded-r border border-solid border-neutral-500 shadow-md"
            name="password"
            type="password"
            value={loginParam.password}
            onChange={handleChange}
          />
        </div>
      </div>

      <div className="flex justify-center">
        <div className="relative mb-4 flex w-full justify-center">
          <div className="w-2/5 p-6 flex justify-center font-bold">
            <button
              className="rounded p-4 w-36 bg-blue-500 text-xl text-white"
              onClick={handleClickLogin}
            >
              LOGIN
            </button>
          </div>
        </div>
      </div>
      <KakaoLoginComponent />
    </div>
  );
};

export default LoginComponent;
