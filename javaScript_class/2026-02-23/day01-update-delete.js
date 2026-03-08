const users = [
  { id: 1, name: '민경', age: 20 },
  { id: 2, name: '철수', age: 25 },
  { id: 3, name: '영희', age: 22 },
];

// 1. id가 3인 사람 age를 40으로 수정한 새 배열 만들기
const ageUpdate = users.map((user) =>
  user.id === 3 ? { ...user, age: 40 } : user,
);

// 2. id가 2인 사람 제거한 새 배열 만들기
const deleteArr = users.filter((user) => user.id !== 2);

// 3. id가 4인 사람을 새로 추가한 배열 만들기
const newArr = [...users, { id: 4, name: '수진', age: 28 }];
