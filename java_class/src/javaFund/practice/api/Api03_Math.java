package javaFund.practice.api;

public class Api03_Math {

	public static void main(String[] args) {
		 /*
	     * [API-03] Math 유틸 클래스
	     *
	     * 요구사항:
	     * 1) Math.max(10, 20) 결과 출력
	     * 2) Math.abs(-15) 결과 출력
	     * 3) Math.random() 사용해서 1~10 사이 정수 출력
	     *
	     * TODO:
	     * - random() 결과 범위 주의
	     */
		
		System.out.println(Math.max(10, 20));
		System.out.println( Math.abs(-15)); // 절댓값
		System.out.println((int)(Math.random()*10) + 1);
	}

}
