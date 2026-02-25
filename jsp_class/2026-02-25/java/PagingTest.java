
public class PagingTest {

	public static void main(String[] args) {
		// 106개의 글 존재함.
		
		// 페이지 범위의 시작값 구해보기
		// 요청된 페이지 - 1 * 10(한 페이지에서 보여질 목록수) + 1;
		// 범위의 끝 값 구해보기,, 페이지 블락을 10으로 기준했을때
		//요청(현재) 페이지 * 10(목록수) 
		
		System.out.println(( 2- 1)*10 + 1); // 시작값
		System.out.println(2*10); // 끝값

		// 여기서 하나 생각할 것.. 2로 처리했을때는 공백 페이지가 생성된다. 
		// -> 11페이지만 필요한데 20까지 생성되는 것을 의미
		// 위의 공백 페이지를 없애는 방법은 실제 글 갯수를 기준으로 페이지의 갯수를 구하는 것이다. 
		// Math.ceil(실제 DB 상의 글 갯수 / 10);
		double p = 106/10.5;
		System.out.println(Math.ceil(p));
		
		// 한 페이지에서 표현될 글 목록수: POSTS_PER_PAGE = 10;
		// 한 블락이 이동되는 블락 수: PAGES_PER_BLOCK = 5;
		
		// 위 산술식으로 하면, 여러분이 
		
		// 91 81 71 61 51 41 [3~1]
		//[이전] 6 7 8 9 10 [다음]
		
		// 이전 페이지 블락을 잡는 연산식..
		// (현재 페이지 -1)/PAGES_PER_BLOCK) * PAGE_PER_BLOCK + 1
		System.out.print(((6-1)/5)* 5 + 1);

	}

}
