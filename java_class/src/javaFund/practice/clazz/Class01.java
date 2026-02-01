package javaFund.practice.clazz;

class Student {
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class Class01 {
	public static void main(String[] args) {
		  /*
	     * [Class-01] 클래스와 객체
	     *
	     * 목표:
	     * - 클래스 정의
	     * - 객체 생성
	     * - 필드 값 접근
	     *
	     * 요구사항:
	     * 1) Student 클래스 정의
	     *    - 필드: name(String), age(int)
	     * 2) main에서 Student 객체 1개 생성
	     * 3) 이름과 나이 값 대입
	     * 4) 이름과 나이 출력
	     *
	     * TODO:
	     * - main 메서드는 이 파일에 작성
	     * - Student 클래스는 같은 파일 아래에 작성
	     */
		
		Student st1 = new Student("민경", 24);
		
		
		
		System.out.println(st1.name);
		System.out.println(st1.age);
	}
}
