package javaFund.practice.collection;

import java.util.HashMap;
import java.util.Map;

public class Collection05 {

	public static void main(String[] args) {
		 /*
         * [Collection-05] Map 인터페이스
         *
         * 목표:
         * - key-value 구조 이해
         *
         * 요구사항:
         * 1) Map<String, Integer> 생성
         * 2) ("math", 90), ("english", 85) 저장
         * 3) math 점수 출력
         *
         * TODO:
         * - put()
         * - get()
         */
		Map<String, Integer> map = new HashMap<>();
		
		map.put("math", 90);
		map.put("english", 85);
		
		System.out.println(map.get("math"));
	}

}
