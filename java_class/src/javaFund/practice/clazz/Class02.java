package javaFund.practice.clazz;

class Calculator {
	int add(int a, int b) {
		return a + b;
	}
}

public class Class02 {

	public static void main(String[] args) {
		/*
		 * [Class-02] 메서드 정의와 호출
		 *
		 * 목표: - 객체의 행동을 메서드로 표현
		 *
		 * 요구사항: 1) Calculator 클래스 정의 2) add(int a, int b) 메서드 작성 - 두 수의 합을 반환 3) main에서
		 * 객체 생성 후 메서드 호출 4) 결과 출력
		 *
		 * TODO: - return 값 있는 메서드
		 */

		Calculator result = new Calculator();

		System.out.println(result.add(1, 3));

	}

}
