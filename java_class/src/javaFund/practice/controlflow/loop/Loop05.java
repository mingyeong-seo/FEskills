package javaFund.practice.controlflow.loop;

public class Loop05 {

	public static void main(String[] args) {
		 /*
         * [Loop-05] 구구단 출력
         *
         * 출력 형식:
         * - 2단부터 9단까지
         * - 각 단은 1~9까지
         *
         * 예:
         * 2 x 1 = 2
         * 2 x 2 = 4
         * ...
         *
         * TODO:
         * 1) 바깥 for문: 단(2~9)
         * 2) 안쪽 for문: 곱(1~9)
         * 3) 출력 형식 정확히 맞추기
         */
		
		for(int i = 2;i<=9;i++) {
			for(int j = 1;j<=9;j++) {
				System.out.println(i+" x "+j+" = "+ i*j);
			}
		}

	}

}
