package javaFund.practice.collection;

import java.util.ArrayList;

public class Collection01 {

	public static void main(String[] args) {
		  /*
         * [Collection-01] 컬렉션 프레임워크 개요
         *
         * 목표:
         * - 컬렉션은 "객체"만 저장한다
         *
         * 요구사항:
         * 1) ArrayList<Integer> 생성
         * 2) 10, 20, 30 추가
         * 3) for문으로 전부 출력
         *
         * TODO:
         * - 기본형(int) 대신 Integer 사용
         */
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(20);
		al.add(30);
		
		for(int i = 0; i < al.size();i++) {
			System.out.println(al.get(i));
		}

	}

}
