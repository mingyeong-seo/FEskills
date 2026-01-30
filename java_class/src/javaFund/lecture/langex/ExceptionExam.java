package javaFund.langex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("가위바위보(1, 2, 3) 입력해");
		int input = 0;
		try {
			input = sc.nextInt();

		} catch (InputMismatchException e) {
			System.out.println("예외발생함");
			System.out.println(e.getMessage());

		}

		System.out.println(input);

		// 파일에 접근하는 API를 사용하려 함.
		try (FileReader fr = new FileReader("src/message.txt")) {
		    int i;
		    while ((i = fr.read()) != -1) {
		        System.out.print((char) i); // 글자마다 줄바꿈 싫으면 print
		    }
		} catch (FileNotFoundException e) {
		    System.out.println("파일 못찾음: " + e.getMessage());
		} catch (IOException e) {
		    System.out.println("읽기 실패: " + e.getMessage());
		}

	}

}
