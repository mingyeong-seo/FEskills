package javaFund.practice.inner;

public class Inner03 {

	public static void main(String[] args) {
		/*
		 * [Inner-03] 내부 인터페이스
		 *
		 * 목표: - 클래스 안에 인터페이스를 둘 수 있음
		 *
		 * 요구사항: 1) Device 클래스 정의 2) Device 안에 interface Switchable 정의 - void on(); 3)
		 * Device 안에 Lamp 클래스 정의 (Switchable 구현) - on() -> "램프 ON" 출력 4) main에서: -
		 * Device.Lamp 생성 - on() 호출
		 *
		 * TODO: - Switchable 타입으로도 참조해보기
		 */

		Device device = new Device();
		Device.Lamp lamp = device.new Lamp();

		lamp.on();

		Device.Switchable sw = lamp; // 인터페이스 타입 참조
		sw.on();

	}

}
