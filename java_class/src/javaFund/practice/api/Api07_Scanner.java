package javaFund.practice.api;

import java.util.Scanner;

public class Api07_Scanner {

	public static void main(String[] args) {
		 /*
	     * [API-07] Scanner 입력
	     *
	     * 요구사항:
	     * 1) Scanner로 정수 1개 입력 받기
	     * 2) 입력값 출력
	     *
	     * TODO:
	     * - Scanner 닫기
	     */
		
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		
		System.out.println(num); 
		
		input.close();

	}

}
//nextInt()    정수
//nextDouble() 실수
//nextLine()   문자열 한 줄
