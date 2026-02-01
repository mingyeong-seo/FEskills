package javaFund.practice.clazz;

class Book {
	String title;
	int price;
	
	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}
}

public class Class03 {

	public static void main(String[] args) {
		 /*
	     * [Class-03] 생성자
	     *
	     * 목표:
	     * - 생성자로 객체 초기화
	     *
	     * 요구사항:
	     * 1) Book 클래스 정의
	     *    - 필드: title(String), price(int)
	     * 2) 생성자에서 필드 초기화
	     * 3) main에서 Book 객체 생성
	     * 4) 제목과 가격 출력
	     *
	     * TODO:
	     * - 생성자 이름 = 클래스 이름
	     */
		
		Book b1 = new Book("책제목", 15000);
		
		System.out.println(b1.title);
		System.out.println(b1.price);

	}

}
