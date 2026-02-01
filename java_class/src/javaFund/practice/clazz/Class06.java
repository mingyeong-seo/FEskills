package javaFund.practice.clazz;


class Counter {
	static int total;
	int count;
	
	public Counter() {
        count++;
        total++;
    }
}

public class Class06 {

	public static void main(String[] args) {
		/*
	     * [Class-06] static과 인스턴스 차이
	     *
	     * 목표:
	     * - 클래스 소속 vs 객체 소속 구분
	     *
	     * 요구사항:
	     * 1) Counter 클래스 정의
	     *    - static int total
	     *    - instance int count
	     * 2) 객체 생성 시 count 1 증가
	     * 3) total도 함께 증가
	     * 4) 객체 2개 생성 후 값 출력
	     *
	     * TODO:
	     * - static은 클래스명으로 접근
	     */
		
		  Counter c1 = new Counter();
	        Counter c2 = new Counter();

	        System.out.println(c1.count);     // 1
	        System.out.println(c2.count);     // 1
	        System.out.println(Counter.total); // 2

	}

}
