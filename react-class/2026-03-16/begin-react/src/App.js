import React, { useCallback, useMemo, useRef, useState } from "react"; // useState → 값이 바뀌면 화면도 같이 바뀌게 해주는 훅, useState → 값이 바뀌면 화면도 같이 바뀌게 해주는 훅
import "./App.css";
import UserList from "./UserList";
import CreateUser from "./CreateUser";

// state: 컴포넌트 내부에서 유동적으로 변할 수 있는 데이터를 다루는 객체

// useCallback: 특정 함수를 새로 만들지 않고 재사용하고 싶을 때 사용하는 훅

function countActiveUser(user) {
  console.log("활성 사용자 수 카운팅..");
  return user.filter((user) => user.active).length;
}

function App() {
  // 입력값 상태
  const [inputs, setInputs] = useState({
    username: "",
    email: "",
  });

  // 구조분해
  const { username, email } = inputs;

  // 사용자 목록 상태(inputs: 현재 입력 상태, setInputs: 입력 상태를 바꾸는 함수), (users: 현재 사용자 목록, users: 사용자 목록 변경 함수)
  const [users, setUsers] = useState([
    {
      id: 1,
      username: "test1",
      email: "test1@test.com",
      active: true,
    },
    {
      id: 2,
      username: "test2",
      email: "test2@test.com",
      active: false,
    },
    {
      id: 3,
      username: "test3",
      email: "test3@test.com",
      active: false,
    },
  ]);
  // nextId: 다음에 생성할 유저 id를 기억하는 변수(지금 users엔 1~3이있으니 다음부턴 4부터 시작해야 한다. 그래서 초기값을 4로 세팅)
  // useRef를 쓰는 이유: 이 값은 화면에 직접 출력되지 않는다. 기억만 하면 되는 값이다. id가 counter니까 useRef가 맞다.
  const nextId = useRef(4); // useRef를 이용해서 초기값을 세팅한다

  // e는 이벤트 객체, e.target은 이벤트가 발생한 대상이다.
  const onChange = (e) => {
    const { name, value } = e.target;

    setInputs({
      ...inputs,
      [name]: value, // 동적으로 key를 바꾸는 문법이다.
    });
  };

  // 등록 버튼 눌렀을 때 실행되는 함수다
  const onCreate = useCallback(() => {
    // 새 이용자 객체 만들기
    const user = {
      id: nextId.current,
      username,
      email,
    };

    // users에 추가(기존 users 배열 뒤에 새 user를 붙여서 새 배열을 만드는 코드)
    setUsers(users.concat(user));

    // 입력칸 초기화
    setInputs({
      username: "",
      email: "",
    });

    // 다음 id 증가
    nextId.current += 1;
  }, [users, username, email]);
  // 주의: 함수 내부에서 사용하는 상태 혹은 Props가 있다면, 꼭 Deps 배열안에 포함 시켜야 한다.
  // 만약 포함하지 않게 되면, 함수내에서 사용하는 값이 최신값임을 보장할 수 없다. 즉, 업데이트가 되지 않을 수 있다

  const onRemove = useCallback(
    (id) => {
      // user.id가 파라미터로 일치하지 않는 요소만 추출해서 새로운 배열을 생성함.
      // filter는 조건에 맞는 것만 남겨서 새 배열을 만든다
      // 현재 user의 id가 삭제하려는 id와 같지 않은 것만 남겨라
      setUsers(users.filter((user) => user.id != id));
    },
    [users],
  );

  const onToggle = (id) => {
    setUsers(
      users.map(
        (
          user, // users 배열을 하나씩 반복
        ) =>
          // 조건문으로 현재 user가 클릭한 user인지 확인
          // active 값 뒤집기
          user.id === id ? { ...user, active: !user.active } : user,
      ),
    );
  };

  const count = useMemo(() => countActiveUser(users), [users]);

  // CreateUser에 전달(입력창과 버튼이 사용할 데이터/함수를 내려주는 것)
  // UserList에 전달(목록을 그리고 삭제를 처리할 수 있게 한다)

  // 활성 사용자 수 : 이름을 클릭해서 active=true 상태가 된 사용자 수
  return (
    <>
      <CreateUser
        username={username}
        email={email}
        onChange={onChange}
        onCreate={onCreate}
      />
      <UserList users={users} onRemove={onRemove} onToggle={onToggle} />
      <div>활성사용자 수: {count}</div>
    </>
  );
}

export default App;
