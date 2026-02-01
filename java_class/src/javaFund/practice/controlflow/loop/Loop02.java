package javaFund.practice.controlflow.loop;

public class Loop02 {

	public static void main(String[] args) {
		  /*
         * [Loop-02] 짝수 제외하고 합 구하기
         *
         * 입력:
         * - int n
         *
         * 규칙:
         * - n <= 0 이면 "INVALID"
         * - 1부터 n까지 중 "홀수만" 더하기
         *
         * 출력:
         * - "sum=____"
         *
         * TODO:
         * 1) n 유효성 검사
         * 2) for문 1~n
         * 3) 짝수면 continue
         * 4) 홀수만 sum 누적
         */
		
		int n = 5;
		int sum = 0;
		
		if (n <= 0) {
			System.out.println("INVALID");
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(i % 2 == 0) {
				continue;
			}
			sum += i;
		}
		
		System.out.println("sum="+sum);

	}

}
