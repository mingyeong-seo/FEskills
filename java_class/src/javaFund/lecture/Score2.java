package javaFund.lecture;

import java.util.Scanner;

public class Score2 {

	public static void main(String[] args) {
		String[] subject = new String[] { "국어", "수학", "영어" };

		// [학생][과목들 + 총점]
		int[][] students = new int[3][subject.length + 1]; 
		int[] avg = new int[3];
		char[] grade = new char[] { ' ', ' ', ' ' };

		Scanner sc = new Scanner(System.in);

		// 학생
		for (int s = 0; s < students.length; s++) { 
			 // 과목
			for (int sub = 0; sub < subject.length; sub++) {
				do {
					System.out.println("학생" + (s + 1) + " " + subject[sub] + " 점수를 입력하세요.");
					while (!sc.hasNextInt()) {
						sc.next();
						System.out.println("정수로 입력하세요.");
					}
					students[s][sub] = sc.nextInt();
				} while (students[s][sub] < 0 || students[s][sub] > 100);

				students[s][subject.length] += students[s][sub]; // 총점 칸(마지막 열)
			}
		}

		// 평균 + 학점, 학생 s
		for (int s = 0; s < students.length; s++) {
			avg[s] = students[s][subject.length] / subject.length;

			switch (avg[s] / 10) {
			case 10:
			case 9:
				grade[s] = 'A';
				break;
			case 8:
				grade[s] = 'B';
				break;
			case 7:
				grade[s] = 'C';
				break;
			default:
				grade[s] = 'F';
			}
		}

		for (int s = 0; s < students.length; s++) {
			System.out.println("학생" + (s + 1) + " 총점은 " + students[s][subject.length] + ", 평균은 " + avg[s] + ", 학점은 "
					+ grade[s] + "입니다.");
		}

		sc.close();
	}
}
