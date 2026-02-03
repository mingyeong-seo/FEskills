package javaFund.practice.collection;

import java.util.HashMap;
import java.util.Map;

public class Collection06 {

	public static void main(String[] args) {
		/*
		 * [Collection-06] Map 반복 처리
		 *
		 * 목표: - Map은 index가 없다
		 *
		 * 요구사항: 1) Map<String, String> 생성 2) ("id", "kim"), ("pw", "1234") 저장 3)
		 * keySet() + for문으로 전부 출력
		 *
		 * 출력 예: id=kim pw=1234
		 */

		Map<String, String> map = new HashMap<>();

		map.put("id", "kim");
		map.put("pw", "1234");

		for (String key : map.keySet()) {
			System.out.println(key + "=" + map.get(key));

		}

	}

}
