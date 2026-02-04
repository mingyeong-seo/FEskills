package java_Fund.ioex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;


public class IOEx3 {
	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("C:\\Temp\\test.txt"); // 문자열을 아래 코드로 바이너리 데이터 변환
		Writer writer = new OutputStreamWriter(os, "UTF-8");
		writer.write(str);
		writer.flush();
		writer.close();

	}

	public static String read() throws Exception {
	    InputStream is = new FileInputStream("C:\\Temp\\test.txt");
	    Reader reader = new InputStreamReader(is, "UTF-8");
	    
	    // 100 size의 char 배열을 생성
	    char[] chArr = new char[100];
	    
	    // 읽은 데이터를 String 타입의 변수에 담기
	    String str = "";
	    
	    int num = reader.read(chArr);
	   
	    reader.close(); // 맨 마지막에 꼽은 스트림만 닫으면 내부적으로 다 닫힘,, 때문에 reader만 close() 호출함
	    
	    String str1 = new String(chArr, 0, num);
	    return str1;

	}

	public static void main(String[] args) throws Exception {
		write("문자 변환 스트림을 사용하는 예시입니다.");

		String data = read();
		System.out.println(data);

	}
	// read() 메서드를 다음과 같이 정의하세요
	/*
	 * Reader에 InputStreamReader를 꼽고, InputStreamReader에는 FileInputStream을 꽂으세요 이렇게
	 * 스트림을 연결한 후, 100 size의 char 배열을 생성해서, reader를 이용해서 읽은 데이터를 String 타입의 변수에 담아서
	 * 리턴시키세요
	 */

}
