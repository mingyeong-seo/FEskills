import { useDispatch, useSelector } from "react-redux";
import { Navigate, useNavigate } from "react-router-dom";
import { loginPostAsync, logout } from "../slice/loginSlice";

const useCustomLogin = () => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  // 로그인 상태
  const loginState = useSelector((state) => state.loginSlice);
  // 로그인 여부
  const isLogin = loginState.email ? true : false;

  // 로그인 함수
  const doLogin = async (loginParam) => {
    return await dispatch(loginPostAsync(loginParam)).unwrap();
  };

  const doLogout = async () => {
    dispatch(logout());
  };

  // 페이지 이동
  const moveToPath = (path) => {
    navigate(path, { replace: true });
  };

  // 로그인 페이지로 이동
  const moveToLogin = () => {
    navigate("/member/login", { replace: true }); // 'member/login' 문자열로 넘겨라
  };

  // 로그인 페이지로 이동 컴포넌트
  const moveToLoginReturn = () => {
    return <Navigate replace to="/member/login" />;
  };

  return {
    loginState,
    isLogin,
    doLogin,
    doLogout,
    moveToPath,
    moveToLogin,
    moveToLoginReturn,
  };
};

export default useCustomLogin;
