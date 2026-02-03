package java_Fund.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 
 * Stream : 그룹핑 되어 있는 요소들(배열, collections, map 등) 을 
 * 빠른 속도로 접근하여 다음 작업들로 연결할 수 있는 기능을 가진 인터페이스
 * 이 스트림을 이용하면, 기존 방식 for, Iterator 등으로만 처리했던 방식을 , 
 * 대체하면서 다양한 중간 처리 방식을 적용할 수 있다. 
 * 속도도 매우 빠르다.*/
@Data
@AllArgsConstructor
// 정렬 기능을 구현하기 위해 Comparable을 구현한다. 
class Student implements Comparable<Student> {
	private String name;
	private int score;
	private String sex;
	@Override
	public int compareTo(Student o) {
		return Integer.compare(score, o.score);
	}
}

@Data // get, set, equals, toString .. 있다.
@AllArgsConstructor // 생성자 생성된다
class Product {
	private int pno;
	private String name;
	private String company;
	private int price;
}

public class StreamEx1 {
	static int sum = 0; // 누적 변수

	public static void main(String[] args) {
		List<String> lt = new ArrayList<String>();
		lt.add("홍길동");
		lt.add("홍길동B");
		lt.add("홍길동C");
		lt.add("홍길동");
		
		lt.stream().distinct().forEach(t -> System.out.println(t)); // 중복 제
		
		

		List<Product> li = new ArrayList<Product>();
		for (int i = 0; i < 5; i++) {
			Product p = new Product(i, "상품" + "i", "삼성", (int) (Math.random() * 10000));

			li.add(p);
		}

		li.stream().filter(t -> t.getPrice()> 5000).forEach(t -> System.out.println(t));
		// 위 li를 스트림으로 생성해서 내부의 Product를 모두 출력해라
		// forEach 이용하라는 뜻

		System.out.println("---------------------");

		Stream<Product> pro = li.stream();
		pro.forEach(t -> System.out.println(t));
		System.out.println("---------------------");
		// 특정 정수 범위만큼의 스트림을 생성해서 값 출력해보기
		IntStream.rangeClosed(0, 100).forEach(i -> sum += i);
		System.out.println(sum);

//		List<Student> list = Arrays.asList(
//					new Student("AA", 10),
//					new Student("BB", 20),
//					new Student("CC", 30)
//				);
//		
//		Stream <Student> str = list.stream();
//		IntStream is = str.mapToInt(student -> student.getScore());
//		OptionalDouble od = is.average(); // 학생 점수 스트림에서 평균을 구한다.
//		double avg = od.getAsDouble(); //  od 객체에서 평균값을 리턴받는다. 
//		
//		Double avg2 = list.stream().mapToInt(std -> std.getScore()).average().getAsDouble();
//		
//		
//		Set<String> set = new HashSet<String>();
//		set.add("A");
//		set.add("B");
//		set.add("C");
//		
//		for(String s: set) {
//			System.out.println(s);
//		}
//		
//		// next()를 무조건 호출하면 요소 없을때 예외 발생, 그래서 확인(hasNext)->꺼냄(next) 순서가 Iterator 사용 규칙이다.
//		Iterator<String> it = set.iterator();
//		while(it.hasNext()){ // 다음값 있니?
//			System.out.println(it.next()); // 다음 요소를 반환하면서 , 커서를 한 칸 이동
//
//		}
//		// 반복제어를 Iterator는 내가, Stream은 Stream이 한다
//		// Stream은 set을 하나씩 읽는 방법만 알고 있다
//		// set.stream()은 이 Set을 대상으로 스트림 처리할 준비만 해 둔다는 의미
//		
//		Stream<String> strem = set.stream(); // 데이터를 순회할 수 있는 Stream 객체를 만든다(이 데이터를 어떻게 처리할지”를 연결하는 파이프라인 인터페이스)
//		strem.forEach(t -> System.out.println(t)); // 실행이 끝나면 스트림은 소모된다. 스트림은 최종 연산을 만나야 실제로 요소를 순회한다. 
//		// forEach(람다)는 스트림의 각 요소를 람다의 매개변수(t)에 넣어 실행하는 최종 연산이다.
//	
	}

}
