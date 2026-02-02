package javaFund.practice.inner;

public class Device {
	interface Switchable {
		void on();
	}
	
	public class Lamp implements Switchable{
		public void on() {
			System.out.println("램프 ON");
		}
	}
}
