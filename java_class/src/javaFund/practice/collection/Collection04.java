package javaFund.practice.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection04 {

	public static void main(String[] args) {
		 /*
         * [Collection-04] Iterator 사용
         *
         * 목표:
         * - 컬렉션을 순회하는 표준 방법
         *
         * 요구사항:
         * 1) List<String> 생성
         * 2) "Kim", "Lee", "Park" 추가
         * 3) Iterator로 전체 출력
         *
         * TODO:
         * - hasNext()
         * - next()
         */
		
		List<String> list = new ArrayList<>();
		list.add("Kim");
		list.add("Lee");
		list.add("Park");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}

	}

}
