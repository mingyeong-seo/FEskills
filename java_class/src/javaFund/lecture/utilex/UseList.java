package java_Fund.utilex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseList {
	public void showUsers(List<Player> lists) {
		// list 내부에 있는 플레이어의 정보를 출력해보기
		Collections.sort(lists); // 오름차순
		Collections.sort(lists, Collections.reverseOrder()); // 내림차순
//		System.out.println(lists.size());
//		System.out.println(lists);
		
		System.out.println(lists.size());
		
		for(int i = 0; i < lists.size();i++) {
			Player player = lists.get(i);
			System.out.println(player.getId());
			System.out.println("-----------");
			System.out.println(player.getName());
			System.out.println(player.getPw());
			System.out.println(player.getLose());
			System.out.println(player.getWin());
			System.out.println(player.getDraw());


		}


	}

}
