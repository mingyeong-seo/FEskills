package javaFund.practice.class01;

/*
 * [문제 2]
 * Student 클래스는 Person을 상속받는다.
 * 
 * 조건:
 * 1. Person을 상속한다.
 * 2. major(String) 필드를 추가한다.
 * 3. name, age, major를 초기화하는 생성자를 만든다.
 *    (부모 생성자를 반드시 호출할 것)
 * 4. info() 메서드를 오버라이드해서
 *    "이름: xxx, 나이: xx, 전공: xxx" 형태로 출력한다.
 */
class Student extends Person {
	String major;

	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}

	@Override
	void info() {
		System.out.println("이름: " + name + ", 나이: " + age + ", 전공: " + major);
	}
}