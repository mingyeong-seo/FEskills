import { lazy, Suspense } from "react";
import { Navigate } from "react-router-dom";
import ReadPage from "../pages/products/ReadPage";

const productsRouter = () => {
  const Loading = <div>...Loading...</div>;
  const ProductsList = lazy(() => import("../pages/products/ListPage"));
  const AddPage = lazy(() => import("../pages/products/AddPage"));
  const ReadPage = lazy(() => import("../pages/products/ReadPage"));
  const ProductModify = lazy(() => import("../pages/products/ModifyPage"));

  return [
    {
      path: "list",
      element: (
        <Suspense fallback={Loading}>
          <ProductsList />
        </Suspense>
      ),
    },
    {
      path: "add",
      element: (
        <Suspense fallback={Loading}>
          <AddPage />
        </Suspense>
      ),
    },
    {
      path: "read/:pno",
      element: (
        <Suspense fallback={Loading}>
          <ReadPage />
        </Suspense>
      ),
    },
    {
      path: "modify/:pno",
      element: (
        <Suspense fallback={Loading}>
          <ProductModify />
        </Suspense>
      ),
    },
    {
      path: "",
      element: <Navigate replace to={"/products/list"} />,
    },
  ];
};

export default productsRouter;
