package javaFund.practice.inner;

public class Outer {
	
	String name = "OUTER";
	
	Inner inner = new Inner();
	
	class Inner {
		void printName() {
			System.out.println(name);
		}
	}

}
