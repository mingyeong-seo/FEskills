package javaFund.lecture;


import java.util.Arrays;

public class ArrayExam {

	public static void main(String[] args) {
		int intArr[] = new int[4]; // 4개 길이의 int 타입의 배열 생성함.
		double[] douArr = { 1, 2, 3 };
		String[] strArr = new String[] { "A", "B", "C" };

		// 위 구문은 배열 생성식이다. 기억하기
		// 배열 객체는 만약 초기값을 주지 않은 상태로 생성하면 각 타입의 기본값으로 자동으로 세팅되어진다.
		// 정수는 0, 실수는 0.0, boolean은 false, Object는 null

		System.out.println(strArr);
		System.out.println(Arrays.toString(strArr));
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}

		// 향상된 for
		for (String str : strArr) {
			System.out.println(str); // str 변수가 배열의 리턴되는 값을 자동으로 대입해서 출력시키도록 함.
		}

		strArr[0] = "hello";
		// strArr[0] = false; 안된다.
		douArr[0] = 10;
		System.out.println(strArr[strArr.length]); // 실행이후 발생되는 에러는 예외

		// 다중 배열,, 배열 내부에 배열을 가지고 있는 형태
		int[] multi[] = new int[2][3]; // 값이 0이 있다.
		//[2][3]은 2행 3열 배열이지만 자바는 숫자 0부터 세니가 0행, 1행으로 구성되어있다
		multi[0][0] = 10;
		multi[1][multi.length] = 50;
		// length는 자기 바로 아래에 몇개가 있냐
		// [2]는 바깥의 multi인 2행을 말하는 거고, [3]은 안쪽 배열 즉, 2행 3열인 그 배열의 길이
		

		for (int i = 0; i < multi.length; i++) {
			for (int j = 0; j < multi[i].length; j++) {
				System.out.println(multi[i][j]);
			}
		}
		
		

	}

}