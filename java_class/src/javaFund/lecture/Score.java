package javaFund.lecture;
import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		/*
		 * 학생의 성적을 국, 영, 수로 입력받아서, 총점, 평균, 학점(A, B, C)를 출력하도록 하는 프로그램입니다. 프로그램이 시작되면 각
		 * 과목을 입력 받도록하는데, 입력된 정수는 반드시 0~100점 사이여야 합니다. 만약 이 범위를 벗어나면 해당 과목을 다시 입력 받도록
		 * 합니다. 다른 과목의 입력으로 넘어가면 안됩니다.
		 * 
		 * 만약 올바른 값이 모두 입력되면, 위 결과를 출력시키세요.
		 * 
		 * 모든 점수는 배열로 관리되어야 합니다. 총점도 학점은 90점 이상은 A, 80점 이상은 B, 70점 이상은 C, 나머지는 F처리하는데
		 * switch로 작성하세요
		 */
		
		// 점수 입력 받기
		boolean isScore = false;
		
		while(!isScore) {
			System.out.println("국어 점수입력");
			Scanner sc = new Scanner(System.in);
			
			int score = sc.nextInt();
		}
		
		
		
		
		
		

	}

}
