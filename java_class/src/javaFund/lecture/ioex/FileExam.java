package java_Fund.ioex;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExam {
	public static void main(String[] args) throws IOException {
		/*
		 * 자바에서는 폴더건 파일이건 모두 file 객체가 관리한다
		 * 폴더인지 파일여부인지는 메서드를 통해 알 수 있다. 
		 */
		
		File file = new File("C:\\parent");
		if(!file.exists()) {
			file.mkdir();		
		}
		
		File file2 = new File(file, "child.dat");
		file2.createNewFile();
		
		File file3 = new File("C:\\Temp");
		if(file3.exists()) {
			// 폴더 내부의 모든 정보를 출력하도록 한다.
			File[] files = file3.listFiles();
			SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd a HH:MM");
			
			for(File f: files) {
				System.out.printf("%-25s", sdf.format(new Date(f.lastModified())));
				
				if(f.isDirectory()) {
					System.out.printf("%-10s%-20s", "<DIR>", f.getName());
				} else {
					System.out.printf("%-10s%-20s", f.length(), f.getName());
				}
				System.out.println();

				}
			}
		}
	}


