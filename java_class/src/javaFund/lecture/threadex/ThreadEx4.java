package java_Fund.threadex;

class Calculator {
    private int memory;

    public void setMemory(int memory) {

        // 동기화 블록
        synchronized (this) {
            this.memory = memory;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":" + this.memory);
        }
    }
}

// 위 공유 객체를 사용하는 스레드 정의
class UserThread1 extends Thread {
    private Calculator calculator;

    public UserThread1() {
        setName("user1Thread");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(100);
    }
}

class UserThread2 extends Thread {
    private Calculator calculator;

    public UserThread2() {
        setName("user2Thread");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(50);
    }
}

public class ThreadEx4 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        UserThread1 userThread1 = new UserThread1();
        userThread1.setCalculator(calculator);
        userThread1.start();

        UserThread2 userThread2 = new UserThread2();
        userThread2.setCalculator(calculator);
        userThread2.start();
    }
}
