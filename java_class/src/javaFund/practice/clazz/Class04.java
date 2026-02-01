package javaFund.practice.clazz;

class User {
	String id;
	
	public User(String id) {
		this.id = id;
	}
}

public class Class04 {

	public static void main(String[] args) {
		/*
	     * [Class-04] this 키워드
	     *
	     * 목표:
	     * - 필드와 매개변수 구분
	     *
	     * 요구사항:
	     * 1) User 클래스 정의
	     *    - 필드: id(String)
	     * 2) 생성자에서 매개변수 id를 받아 필드에 저장
	     * 3) this 사용
	     * 4) main에서 객체 생성 후 id 출력
	     *
	     * TODO:
	     * - this.id = id 구조 사용
	     */
		
		User u1 = new User("아이디");
		
		System.out.println(u1.id);
	}

}
