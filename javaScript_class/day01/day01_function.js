// 1. 짝수/홀수 함수
// checkEven(2) → 짝수
// checkEven(3) → 홀수

function checkEven(num) {
  if (num % 2 === 0) {
    return '짝수';
  } else {
    return '홀수';
  }
}

console.log(checkEven(2));
console.log(checkEven(3));

// 2. 3의 배수 함수
// checkThree(3) → 3의 배수
// checkThree(2) → 아님

function checkThree(num2) {
  if (num2 % 3 === 0) {
    return '3의 배수';
  } else {
    return '아님';
  }
}

console.log(checkThree(3));
console.log(checkThree(2));

// 3. 점수 함수
// getGrade(88) → B
// getGrade(95) → A

function getGrade(score) {
  if (score >= 90) {
    return 'A';
  } else if (score >= 80) {
    return 'B';
  } else if (score >= 70) {
    return 'C';
  } else {
    return 'D';
  }
}

console.log(getGrade(88));
console.log(getGrade(95));
