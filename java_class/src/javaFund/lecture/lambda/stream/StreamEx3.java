package java_Fund.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;


// 많이 쓰니 기억하자
public class StreamEx3 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		// 리스트에 요소가 하나도 없다
		// 일부러 예외를 발생시켜 보자.
		
//		double avg = list.stream()
//				.mapToInt(Integer :: intValue)
//				.average()
//				.getAsDouble();
		OptionalDouble optional = list.stream()
		.mapToInt(Integer :: intValue)
		.average();
		
		// 데이터가 존재 하는지를 체크해서 로직을 작성할 수 있다. 
		if(optional.isPresent()) {
			System.out.println("평균: "+optional.getAsDouble());
		} else {
			System.out.println("평균: "+"0");

		}
		
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(0.0);
		
		System.out.println("방법 2 평균 : " + avg);

		// 방법 3 
		list.stream()
		.mapToInt(Integer :: intValue)
		.average()
		.ifPresent(value -> System.out.println("방법 3 평균: "+value));
		
		
		Student str = null;
		
	}
	
	

}
