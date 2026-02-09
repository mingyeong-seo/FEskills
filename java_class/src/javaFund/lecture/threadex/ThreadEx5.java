package java_Fund.threadex;
/*
 * Daemon 스레드: 기본적으로 새롭게 생성된 스레드는 run()을 다 수행할 때까지, 자신을 생성한 스레드의
 * 생명 주기와는 상관없이 수행된다. 이 말은 자신을 생성한 스레드가 종료되도, 새로운 스레드는 종료가
 * 안 될 수 있다는 말이다. */

public class ThreadEx5 {
	public static void main(String[] args) {
		Thread newTh = new Thread(() -> {
			while (true) {
				System.out.println(Thread.currentThread().getName() + " 이 작업함");

			}
		});
		// setDaemon(true);를 호출해서 자신을 생성한 스레드와 생명주기를 같게 만든다. 
		newTh.setDaemon(true);
		newTh.start();
		System.out.println("메인 스레드 작업 종료됨");

	}

}
