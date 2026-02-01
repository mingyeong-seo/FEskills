package javaFund.practice.array;

public class Array06 {

	public static void main(String[] args) {
		 /*
         * [Array-06] 2차원 배열 전체 출력
         *
         * 배열:
         * int[][] matrix = {
         *   {1, 2, 3},
         *   {4, 5, 6}
         * };
         *
         * 요구사항:
         * - 중첩 for문으로 모든 값 출력
         *
         * 출력 예:
         * 1 2 3
         * 4 5 6
         *
         * TODO:
         * - 바깥 for: 행
         * - 안쪽 for: 열
         */
		int[][] matrix = {
				{1, 2, 3}, 
				{4, 5, 6}
		};
		
		for(int i = 0; i < matrix.length;i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		

	}

}
