// 문제 1 — 짝수 / 홀수
// 숫자 하나 → 짝수면 "짝수", 아니면 "홀수"
const num = 2;

if (num % 2 === 0) {
  console.log('짝수');
} else {
  console.log('홀수');
}

// 문제 2 — 3의 배수
// 숫자 하나 → 3의 배수면 "3의 배수", 아니면 "아님"
const num1 = 2;
if (num1 % 3 === 0) {
  console.log('3의 배수');
} else {
  console.log('아님');
}

// 문제 3 — 점수 등급
// 점수 입력 →

// 90 이상 A
// 80 이상 B
// 70 이상 C
// 나머지 D

const num2 = 88;
if (num2 >= 90) {
  console.log('A');
} else if (num2 >= 80) {
  console.log('B');
} else if (num2 >= 70) {
  console.log('C');
} else {
  console.log('D');
}
