package javaFund.practice.api;

import java.util.HashMap;

public class Api06_HashMap {

	public static void main(String[] args) {
		/*
	     * [API-06] HashMap 기본
	     *
	     * 요구사항:
	     * 1) HashMap<String, Integer> 생성
	     * 2) ("apple", 1000), ("banana", 1500) 저장
	     * 3) apple 가격 출력
	     *
	     * TODO:
	     * - put()
	     * - get()
	     */
		
		HashMap<String, Integer> fruit = new HashMap<>();
		
		fruit.put("apple", 1000);
		fruit.put("banana", 1500);
		
		System.out.println(fruit.get("apple"));

	}

}
