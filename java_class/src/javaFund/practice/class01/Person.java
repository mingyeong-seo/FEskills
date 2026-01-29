package javaFund.practice.class01;

/*
 * [문제 1]
 * 사람(Person)을 표현하는 클래스를 만들어보자.
 * ss
 * 조건:
 * 1. name(String), age(int) 필드를 가진다.
 * 2. name과 age를 초기화하는 생성자를 만든다.
 * 3. info() 메서드를 만들어서
 *    "이름: xxx, 나이: xx" 형태로 출력한다.
 * 
 * main 메서드는 만들지 않는다.
 */

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void info() {
		System.out.println("이름: " + name + ", 나이: " + age);
	}
}