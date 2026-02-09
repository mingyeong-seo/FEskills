package java_Fund.threadex;

import lombok.Data;

@Data
class SumThread extends Thread {
	private long sum;
	
	public long getSum() {
        return sum;
    }

	@Override
	public void run() {
		for (int i = 0; i <= 100000; i++) {
			sum += i;
		}
	}
}


class WorkThread extends Thread {
	public boolean work = true;
	
	public WorkThread(String name) {
		setName(name);
	}
	
	public void setName(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName() + ": 작업 처리");
			}else {
				Thread.yield();
			}
		}
	}
}

public class ThreadEx3 {
	public static void main(String[] args) {
		
		WorkThread workThreadA = new WorkThread("WorkThreadA");
		WorkThread workThreadB = new WorkThread("WorkThreadB");

		workThreadA.start();
		workThreadB.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		workThreadA.work = false;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		workThreadA = true;
		
		
		SumThread sumThread = new SumThread();
		sumThread.start(); // 스레드 start
		try {
//			Thread.sleep(100);
			sumThread.join(); // sumThread의 run()이 끝날때까지 실행 main은 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100 까지의 합: " + sumThread.getSum());

		/*
		 * 스레드 클래스의 메서드를 이용한 스레드의 제어 기본적으로 스레드는 생성하는 순간 경쟁 상태이다. 즉, 서로 CPU를 점유하려고 경쟁을
		 * 한다는 의미이다. 이때, 특정 스레드가 CPU를 점유 후 자신의 작업을 모두 끝내도록 다른 스레드는 실행 대기 상태에 빠지게 하고, 작업
		 * 후 이들을 호출해서 다른 스레드가 작업을 수행하도록 할 수 있다. 이것들은 메서드를 통해 제어가 된다.
		 *
		 *
		 * 일시정지로 보냄: sleep(), join(): 호출한 스레드가 일시 정지 상태로 된다. 실행대기 상태로 가려면, join()를 가진
		 * 스레드가 run을 모두 끝낸 상태인 즉 종료 상태로 되어야만 한다.
		 *
		 * yield(): 실행 상태에서 다른 스레드에게 시랳ㅇ을 양보하고 시행 대기 상태가 된다
		 **/
	}
}
