package java_Fund.ioex;

import java.io.FileReader;
import java.util.Arrays;

public class IOEx2 {

	public static void main(String[] args) {
		/*
		 * 문자를 쓰고 읽는데 특화된 Reader, Writer 대표적인 메서드인 write(int character)가 있고, 이 외에 문자열을
		 * 직접 쓸 수 있도록 메서드가 정의되어짐
		 * 
		 * 어디에 쓸 것인지는 자식 클래스로 객체 생성해서 대상을 지정함
		 */

		try {

			/*
			 * 다음과 같은 로직을 작성하시오. 1. read()를 이용해서 test.txt 파일을 읽어서 콘솔에 출력하는 로직 작성 2.
			 * read(char[] arr)을 이용해서 위 chArr을 이용, text.txt 파일을 읽어서 콘솔에 출력하는 로직을 작성하시오.
			 * 
			 * 결과는 test.txt 파일의 내용이 두 번 출력 되어야 한다
			 */
			
			FileReader fr2 = new FileReader("C:/Temp/test.txt");
			int data;
			while((data = fr2.read()) != -1) {
				System.out.println((char)data);

			}
			fr2.close();
			System.out.println("=======================");
			
			FileReader fr = new FileReader("C:/Temp/test.txt");
			// read(char[] arr) 이용
			char[] chArr = new char[100];
			while (true) {
				int num = fr.read(chArr);
				if (num == -1)
					break;
//				for (int i = 0; i < num; i++) {
//					System.out.println(chArr[i]);
//				}
				System.out.println(Arrays.toString(chArr));
			}
			fr.close();
			// 문자 기반 출력 스트림 생성함
//			FileWriter writer = new FileWriter("C:/Temp/test.txt");
//
//			char a = 'A';
//			writer.write(a);
//
//			char b = 'B';
//			writer.write(b);
//
//			// char 배열 출력
//			char[] arr = { 'c', 'd', 'e' };
//			writer.write(arr);
//
//			// 문자열 출력
//			writer.write("FGHI");

			// 버퍼에 잔류한 데이터를 출력하고 버퍼 닫음

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
