package javaFund.practice.api;

class User {
    String id;

    User(String id) {
        this.id = id;
    }
}

public class Api02_Object {

	public static void main(String[] args) {
		 /*
	     * [API-02] equals vs ==
	     *
	     * 요구사항:
	     * 1) User 객체 2개 생성 (id 값 동일)
	     * 2) == 비교 결과 출력
	     * 3) equals 비교 결과 출력
	     *
	     * TODO:
	     * - 결과가 왜 다른지 생각
	     */// TODO Auto-generated method stub
		
		User u1 = new User("123");
		User u2 = new User("123");
		
		System.out.println(u1 == u2);
		System.out.println(u1.equals(u2));

	}

}
