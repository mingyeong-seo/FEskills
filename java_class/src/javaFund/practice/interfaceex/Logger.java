package javaFund.practice.interfaceex;

public interface Logger {

    default void log() {
        System.out.println("로그 출력");
    }

    static void info() {
        System.out.println("정보 출력");
    }
}
