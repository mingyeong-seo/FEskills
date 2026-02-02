package javaFund.practice.api;

import java.util.ArrayList;

public class Api05_ArrayList {

	public static void main(String[] args) {
		 /*
	     * [API-05] ArrayList 기본
	     *
	     * 요구사항:
	     * 1) ArrayList<String> 생성
	     * 2) "Kim", "Lee", "Park" 추가
	     * 3) for문으로 전부 출력
	     * 4) size() 출력
	     *
	     * TODO:
	     * - 배열과 다른 점 느껴보기
	     */
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("Kim");
		list.add("Lee");
		list.add("Park");
		
		for(int i = 0;i <list.size();i ++) {
			System.out.println(list.get(i));
		}
		
		System.out.println(list.size());

	}

}
