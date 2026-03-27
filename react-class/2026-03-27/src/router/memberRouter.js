import { lazy, Suspense } from "react";

const loading = <div>loading.........</div>;
const Login = lazy(() => import("../pages/member/LoginPage"));
const Logout = lazy(() => import("../pages/member/LogoutPage"));

const memberRouter = () => {
  return [
    {
      path: "login",
      element: (
        <Suspense fallback={loading}>
          <Login />
        </Suspense>
      ),
    },
    {
      path: "logout",
      element: (
        <Suspense fallback={loading}>
          <Logout />
        </Suspense>
      ),
    },
  ];
};

export default memberRouter;

/* React Router가 기본적으로 경로 매칭을 대소문자 구분 없이 하기 때문에 caseSensitive = false가 기본값이다. 구분하고 싶다면 true를 준다 */
