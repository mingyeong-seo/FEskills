import { lazy, Suspense } from "react";
import { Navigate } from "react-router-dom";

const productsRouter = () => {
  const Loading = <div>...Loading...</div>;
  const ProductsList = lazy(() => import("../pages/products/ListPage"));
  const AddPage = lazy(() => import("../pages/products/AddPage"));

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
      path: "",
      element: <Navigate replace to={"/products/list"} />,
    },
  ];
};

export default productsRouter;
