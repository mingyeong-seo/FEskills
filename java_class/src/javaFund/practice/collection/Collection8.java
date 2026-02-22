package javaFund.practice.collection;

import java.util.HashMap;
import java.util.Map;

public class Collection8 {
	// 저장소(전역으로 둔다)
	static Map<Integer,String> store = new HashMap<>();
	
	public static void main(String[] args) {
		addUser(1,"민경");
		addUser(2, "철수");
		
		getUser(1);
		deleteUser(1);
		getUser(1);
	}
	
	//추가
	public static void addUser(int id, String name) {
		store.put(id, name);
		System.out.println("저장 완료");
	}
	
	// 조회
	public static void getUser(int id) {
		if(store.containsKey(id)) {
			System.out.println("조회 결과: " + store.get(id));
		} else {
			System.out.println("존재하지 않는 id");
		}
	}
	
	// 삭제
	public static void deleteUser(int id) {
		if(store.containsKey(id)) {
			store.remove(id);
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제할 데이터 없음");
		}
	}
	// add 구조: 입력받음 -> 저장 -> 끝
	// get 구조: 존재 확인->있으면 출력->없으면 안내
	// delete구조: 존재 확인->있으면 삭제->안내
	
	// 📌 다음 단계에서 할 것
//update 추가
//
//DTO로 확장
//
//static 제거하고 객체지향으로 변경
}
