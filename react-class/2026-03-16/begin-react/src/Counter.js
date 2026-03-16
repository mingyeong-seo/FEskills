// 컴포넌트에 동적으로 같이 변화해야 할 때 사용되는 대표적인 hook인 useState를 알아보자
// 자바의 setter 와 비슷한 역할을 한다고 생각하자
import React, { useState } from "react";

function Counter() {
  const [number, setNumber] = useState(0);

  const onIncress = () => {
    setNumber((preNumber) => preNumber + 1);
    console.log("+1");
  };

  const onDecress = () => {
    setNumber((preNumber) => preNumber - 1);
    console.log("-1");
  };
  return (
    <div>
      <h1>{number}</h1>
      <button onClick={onIncress}>+1</button>
      <button onClick={onDecress}>-1</button>
    </div>
  );
}

export default Counter;
