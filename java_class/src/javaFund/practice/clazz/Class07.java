package javaFund.practice.clazz;

class Singleton {

	// 유일한 객체
	private static Singleton instance = new Singleton();

	// 생성자 private
	private Singleton() {
	}

	// 객체 반환 메서드
	public static Singleton getInstance() {
		return instance;
	}
}

public class Class07 {

	public static void main(String[] args) {
		/*
		 * [Class-07] 싱글톤 패턴
		 *
		 * 목표: - 객체 하나만 생성되도록 제한
		 *
		 * 요구사항: 1) Singleton 클래스 정의 2) 생성자 private 3) static 메서드로 객체 반환 4) main에서 객체 2번
		 * 요청 5) 두 객체가 같은지 비교
		 *
		 * TODO: - new 사용 금지
		 */

		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s1 == s2); 
	}

}
