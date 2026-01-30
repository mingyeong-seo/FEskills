package java_Fund.utilex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * ArrayList: 컬렉션의 대표적인 클래스, 같은 타입의 객체를 배열처럼 관리하는 자료구조형
 * */

public class ListExam {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList(); // Integer 객체만 요소로 관리하겠다는 의미 <제네릭>
		System.out.println(list.size());

		list.add(1);
		list.add(2);
		list.add(3);

		System.out.println(list.size());

		Integer i = list.get(0);

		for (int ii = 0; ii < list.size(); ii++) {
			System.out.println(list.get(ii));

		}

		list.add(0, 100); // 지정된 위치(0)에 지정된 요소(100)넣기
		System.out.println(list);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(300); // 지정된 요소(300)을 이 목록의 끝에 추가한다

		// 리스트에 리스트 넣기
		list2.addAll(list); // 지정된 컬렉션의 모든 요소를 지정된 위치부터 시작하여 이 목록에 삽입한다
		System.out.println(list2);

		System.out.println(list2.contains(3)); // 지정된 요소가 포함되어 있는지 여부를 반환한다.

		list2.clear();
		System.out.println(list2);

		// set()을 이용해서 1번 요소의 값을 2000으로 대처하세요.
		list.set(1, 2000);

		// Player 3명을 생성한다.
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();

		p1.setId("p1");
		p1.setPw("1234");
		p1.setName("게이머1");
		p1.setLose((int) (Math.random() * 10));
		p1.setWin((int) (Math.random() * 10));
		p1.setDraw((int) (Math.random() * 10));

		p2.setId("p2");
		p2.setPw("3456");
		p2.setName("게이머2");
		p2.setLose((int) (Math.random() * 10));
		p2.setWin((int) (Math.random() * 10));
		p2.setDraw((int) (Math.random() * 10));

		p3.setId("p3");
		p3.setPw("6789");
		p3.setName("게이머3");
		p3.setLose((int) (Math.random() * 10));
		p3.setWin((int) (Math.random() * 10));
		p3.setDraw((int) (Math.random() * 10));

		List<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		players.add(p3);

		new UseList().showUsers(players);

//		List<Integer> li = new ArrayList<Integer>();
//		li.add((int) (Math.random() * 10));
//		li.add((int) (Math.random() * 10));
//		li.add((int) (Math.random() * 10));
//		li.add((int) (Math.random() * 10));
//		li.add((int) (Math.random() * 10));
//
//		System.out.println(li);
//
//		// Collections 라는 클래스의 메서드를 이용해서 정렬한다.
//		Collections.sort(li, Collections.reverseOrder()); // 내림차순
//		// Collections.sort(li) 오름 차순
//
//		System.out.println(li);

	}

}
