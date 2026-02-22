package javaFund.practice.collection;

import java.util.HashMap;
import java.util.Map;

public class Collection07 {
	public static void main(String[] args) {
		Map<Integer, String> store = new HashMap<>();
		// add
		store.put(1,"공부하기");
		store.put(2, "운동하기");
		// get
		System.out.println(store.get(1));
		// 삭제 후 다시 조회
		store.remove(1); // delete
		System.out.println(store.get(1));
		
		// CRUD에서 존재 여부 확인은 containsKey()를 쓰는게 더 명확하고 안전하다
		if(store.containsKey(1)) {
			System.out.println("존재함");
		} else {
			System.out.println("없음");
		}
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		
		System.out.println(map.get(1));
		
		// keySet-연습
		for(Integer key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
		// entrySet-연습
		for(Map.Entry<Integer,String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// keySet()은 Map안에 모든 key들을 모아서 Set 형태로 반환하는 메서드( 1->A 2->B를 [1,2]로)
		for(Integer key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
		// entrySet
		for(Map.Entry<Integer,String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
//		map.remove(1);
//		
//		System.out.println(map.get(1));
		// 간단 CRUD 함수화
//		public static void add(Map<Integer,String> map, int id, String value) {
//			map.put(id,value);
//		}
	}
}
