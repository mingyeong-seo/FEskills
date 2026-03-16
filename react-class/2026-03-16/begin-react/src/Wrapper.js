// 컴포넌트 사이에 존재하는 값을 조회할 때는 props.children 을 이용한다
import React from "react";

function Wrapper({ children }) {
  const style = {
    border: "2px solid black",
    padding: "16px",
  };

  return <div style={style}>{children}</div>;
}

export default Wrapper;
