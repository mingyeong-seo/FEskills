import React, { useEffect } from "react";

function User({ user, onRemove, onToggle }) {
  // useEffect() : 컴포넌트가 화면에 나타나거나 사라질때, Props의 상태값이 바뀔때 등의 상태에서
  // 사용할 수 있는 hook,
  // 이 훅을 사용하는 이유는 화면이 나타날때 API를 호출한다거나 image, video 같은 리소스를
  // 가져올 때 등의 목적이며, 다 사용하고 난 후에 api 호출을 끊는 등의 작업을 하도록 유도한다

  // 화면이 나타날때(mount) , 사라질때 호출 여부를 확인해보자
  useEffect(() => {
    console.log("user 값이 설정되었음");
    console.log(user);
    return () => {
      // 이건 클린업 함수라고 한다.
      console.log("user가 바뀌기 전");
      console.log(user);
    };
  }, [user]); // 의존성 데이터를 넣거나 뺄 수 있다.. 만약 빼는 경우엔 컴포넌트가 처음 나타날 때만 useEffect에 등록한 함수가 호출된다..

  // deps: 의존성 변수의 활용법.. 여기에 특정 값을 넣게되면 컴포넌트가 처음 마운트 될때도 호출되고, 지정된 값이 변경될 때도 호출된다..

  return (
    <div>
      <b
        style={{
          cursor: "pointer",
          color: user.active ? "green" : "black",
        }}
        onClick={() => onToggle(user.id)}
      >
        {user.username} <span>({user.email})</span>
      </b>
      <button onClick={() => onRemove(user.id)}>삭제</button>
    </div>
  );
}

function UserList({ users, onRemove, onToggle }) {
  return (
    <div>
      {users.map((user, idx) => (
        <User user={user} key={idx} onRemove={onRemove} onToggle={onToggle} />
      ))}
    </div>
  );
}

export default UserList;
