// 문제
// 배열 [1,2,3,4,5]를 받아서
// 짝수만 반환하는 함수 만들어라 => 조건에 맞는 것만 남기는 것이다. filter 사용해야 한다.

// 함수 형태: getEvenNumbers(arr)

function getEvenNumbers(arr) {
  return arr.filter((num) => num % 2 === 0);
}

console.log(getEvenNumbers([1, 2, 3, 4, 5]));

// 문제
// [1,2,3,4,5] → 홀수만 반환

function getOddNumbers(arr) {
  return arr.filter((num) => num % 2 !== 0);
}
console.log(getOddNumbers([1, 2, 3, 4, 5]));

// 문제
// [10,20,30,15] → 20 이상만 반환
function getTwenty(arr) {
  return arr.filter((num) => num >= 20);
}
console.log(getTwenty([10, 20, 30, 15]));

// JS에서는 무조건 ===, !== 사용

// 문제
// [1,2,3,4,5] → 짝수만 *2 해서 반환
// function getEvenMultiple(arr) {
//   let evenArr = arr.filter((num) => num % 2 === 0);
//   return evenArr.map((number) => number * 2);
// }

function getEvenMultiple(arr) {
  return arr.filter((num) => num % 2 === 0).map((num) => num * 2);
}
console.log(getEvenMultiple([1, 2, 3, 4, 5]));

// 문제
// const users = [
//   { name: "A", age: 20 },
//   { name: "B", age: 30 },
//   { name: "C", age: 25 }
// ];

// → age 25 이상인 사람 이름만 배열로 반환

const users = [
  { name: 'A', age: 20 },
  { name: 'B', age: 30 },
  { name: 'C', age: 25 },
];

function userFilter(users) {
  return users.filter((user) => user.age >= 25).map((user) => user.name);
}

console.log(userFilter(users));

// 문제
// const users = [
//   { name: "A", age: 20 },
//   { name: "B", age: 30 },
//   { name: "C", age: 25 }
// ];

// age 25 이상인 사람의 나이만 배열로 반환

const users2 = [
  { name: 'A', age: 20 },
  { name: 'B', age: 30 },
  { name: 'C', age: 25 },
];

function age25(users) {
  return users.filter((user) => user.age >= 25).map((user) => user.age);
}

console.log(age25(users2));

// 문제
// [1,2,3,4,5] → 홀수만 *3 해서 반환
function oddNewArray(arr) {
  return arr.filter((num) => num % 2 !== 0).map((num) => num * 3);
}

console.log(oddNewArray([1, 2, 3, 4, 5]));

// 문제
// const numbers = [1,2,3,4,5]; → 3 이상인 숫자만 *2 해서 반환

const numbers = [1, 2, 3, 4, 5];
function over3Multiple(numbers) {
    return numbers
        .filter(number => number >= 3)
        .map(number => number * 2)
}

console.log(over3Multiple(numbers));
