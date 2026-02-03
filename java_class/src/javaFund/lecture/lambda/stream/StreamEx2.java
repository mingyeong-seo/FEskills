package java_Fund.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamEx2 {

	public static void main(String[] args) {
		// 요소를 하나씩 처리하는 메서드 peek(), forEach()

		int[] intArr2 = { 2, 4 };
		int total = Arrays.stream(intArr2).filter(value -> value % 2 == 0).peek(value -> System.out.println(value))
				.sum();

		System.out.println(total);
		// peak()은 최종 집계나 함수 처리를 해야만 수행 가능하다
		System.out.println("---------------------");

		boolean result = Arrays.stream(intArr2).allMatch(value -> value % 2 == 0); // 모두 일치하는 것만 추출
		System.out.println(result);
		System.out.println("---------------------");

		// noneMatch를 이용해서 3의 배수가 없는지의 여부를 검증해보세요.
		boolean result2 = Arrays.stream(intArr2).noneMatch(value -> value % 3 == 0);
		System.out.println(result2);
		System.out.println("---------------------");

		// Student 객체 3개를 ArraysList list3에 담아보기
		Student st1 = new Student("민경", 100, "여");
		Student st2 = new Student("민경2", 90, "여");
		Student st3 = new Student("민경3", 80, "여");
		ArrayList<Student> list3 = new ArrayList<Student>(); // ArraysList list2 생성
		list3.add(st1); // 담기는 add
		list3.add(st2);
		list3.add(st3);

		list3.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.println(t));

		System.out.println("---------------------");
		List<String> listl1 = new ArrayList<String>();
		listl1.add("자바 수업중");
		listl1.add("빠르면 말하기");

		listl1.stream().flatMap(t -> Arrays.stream(t.split(" "))) // Stream 안의 Stream을 풀어서 하나의 Stream으로 합친다
				.forEach(word -> System.out.println(word));
		System.out.println("---------------------");

		List<String> list2 = Arrays.asList("10", "20", "30", "40", "50");
		list2.stream().flatMapToInt(data -> {
			String[] strArr = data.split(",");
			int[] intArr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		}).forEach(number -> System.out.println(number));

		System.out.println("---------------------");

		List<Student> list = new ArrayList<Student>();

		list.add(new Student("홍길동", 85, "여"));
		list.add(new Student("아이언맨", 90, "여"));
		list.add(new Student("홍길동이", 95, "여"));

		// Student를 Score 스트림으로 반환
		list.stream().mapToInt(value -> value.getScore()).forEach(value -> System.out.println(value));

	}

}
