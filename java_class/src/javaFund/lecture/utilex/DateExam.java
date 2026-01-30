package java_Fund.utilex;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class DateExam {
	public static void main(String[] args) {
		/*
		 * 
		 * Date 클래스: 날짜와 시간을 관리하는 클래스 대부분의 API가 Deprecated 되어 있어서, Calendar 클래스를 사용하도록
		 * 권장되나 기본 API들을 많이 사용한다
		 */

		Date now = new Date();
		System.out.println(now);

		// SimpleDateFormat은 자주 사용하니 기억하자
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
		String formatDate = sdf.format(now);
		System.out.println(formatDate);

		Calendar cNow = Calendar.getInstance(); // 현재 시간을 나타내는 객체 get
		System.out.println(cNow);

		int year = cNow.get(Calendar.YEAR);
		System.out.println(year);

		// 이번주가 몇번째 주인지 확인해보기
		System.out.println(cNow.get(Calendar.WEEK_OF_MONTH));
		System.out.println(cNow.get(Calendar.WEEK_OF_YEAR));

		// 지금부터 크리스마스 날짜까지 얼마나 남았는지
		Calendar xmas = Calendar.getInstance();
		xmas.set(2026, 11, 25);

		int diff = xmas.get(Calendar.DAY_OF_YEAR) - cNow.get(Calendar.DAY_OF_YEAR);
		System.out.println(diff);

		// cNow는 현재 시간을 가지고 있다.
		// 이 시간 값을 이용해서 다음처럼 출력해라
		// SimpleDateFormat 을 이용해라..
		// "현재 시간은 오후?시 ?분 ?초 입니다."

		Date d = cNow.getTime();
		sdf = new SimpleDateFormat("현재 시간은 a h시 MM분 ss초 입니다.");
		System.out.println(sdf.format(d));

//		 // 현재 시간 이미 위에서 Calendar cNow = Calendar.getInstance();  함.
//		 int hour = cNow.get(Calendar.HOUR_OF_DAY);
//		 int min = cNow.get(Calendar.MINUTE);
//		 int sec = cNow.get(Calendar.SECOND);
//		 
//		 System.out.println("현재 시간은 오후 "+hour+"시 "+min+"분 "+sec+"초 입니다.");
//
		// 0~10 사이의 랜덤한 값을 갖는 5개 배열을 생성해서 이를 오름차순으로 정렬후 배열 결과를 출력하세요.
		// sort(int 배열, 0,배열 길이 -1)

		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 11);
		}

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Pattern pa = Pattern.compile("s[a:z]*"); //s로 시작하는 알파벳 소문자가 8개 이상 패턴
		Matcher ma = null;
		
		ma = pa.matcher("super man");
		System.out.println(ma.matches());

	}
}
