// day01-map-spread.js

const users = [
  { id: 1, name: '민경', age: 20 },
  { id: 2, name: '철수', age: 25 },
];

// 1️. name만 배열로 만들기
const nameArr = users.map((user) => user.name);

// 결과: ["민경", "철수"]
console.log(nameArr);
// 2️. id가 2인 사람 age를 30으로 수정한 새 배열 만들기
// 원본 users는 절대 변경하면 안 됨
const updateUsers = users.map((user) =>
  user.id === 2 ? { ...user, age: 30 } : user,
);
console.log(updateUsers);
// 3️. id가 1인 사람 제거한 새 배열 만들기
// filter 사용
const filteredUsers = users.filter((user) => user.id !== 1);
console.log(filteredUsers);
console.log('원본:', users);
