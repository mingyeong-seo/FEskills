package javaFund.practice.controlflow.loop;

public class Loop01 {

	public static void main(String[] args) {
		 /*
         * [Loop-01] 1부터 N까지 합 구하기
         *
         * 입력:
         * - int n
         *
         * 규칙:
         * - n <= 0 이면 "INVALID" 출력 후 종료
         * - 1부터 n까지의 합을 계산
         *
         * 출력:
         * - "sum=____"
         *
         * TODO:
         * 1) 실패 조건(n <= 0) 먼저 처리
         * 2) for문으로 누적 합 계산
         * 3) sum 출력
         */
		
		int n = 10;
		int sum = 0;
		
		if(n <= 0) {
			System.out.println("INVALID");
			return;
		}
		
		for(int i = 1; i <= n;i++) {
			sum += i;
		}
		
		System.out.println("sum="+sum);
		
	}

}
