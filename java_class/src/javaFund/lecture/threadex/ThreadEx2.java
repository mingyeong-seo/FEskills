package java_Fund.threadex;

import java.awt.Toolkit;

// Thread를 직접 상속받아서 구현한다.
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + " 스레드 수행");

        for (int i = 0; i < 5; i++) {
            System.out.println("hello");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Runnable 구현 방식
class YourThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("your thread");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadEx2 {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " 실행됨");

        // 1) Runnable 객체를 target으로 넣은 스레드
        Thread yThread = new Thread(new YourThread());
        yThread.start();

        // 2) Thread 상속한 스레드
        Thread myThread = new MyThread();
        myThread.start();

        // 3) 익명 Runnable로 만든 비프 스레드
        Thread beepThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        beepThread.start();

        // 4) 람다식으로 만든 스레드(예: "lambda thread" 출력)
        Thread lambdaThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("lambda thread");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        lambdaThread.start();

        // main 스레드 작업
        for (int i = 0; i < 5; i++) {
            System.out.println("딩동");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
