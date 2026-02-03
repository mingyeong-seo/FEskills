package java_Fund.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * List에 저장된 Member 의 평균 나이를 출력하세요*/

//average()

@Data
@AllArgsConstructor
class Member {
	private String name;
	private int age;
	private String job;
}

public class StreanQuiz2 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("AA", 40, "developer"), new Member("BB", 25, "designer"),
				new Member("CC", 37, "developer"));

		// 위 리스트에서 직업이 developer인 객체만 추려서
		// developer 라는 리스트로 새롭게 생성 후 직업을 출력하시오.

		List<Member> developers = list.stream().filter(member -> member.getJob().equalsIgnoreCase("developer"))
				.collect(Collectors.toList());

		developers.forEach(member -> System.out.println(member.getJob()));

		// 여기에 평균을 구하는 코드 작성,, 스트림을 이용한다
		double avg = list.stream().mapToInt(member -> member.getAge()) // 객체에서 int 값만 뽑아서 숫자 전용 스트림으로 바꿔주는 것
				.average().getAsDouble(); // OptionalDouble 안에 들어 있는 실제 double 값을 꺼낸다
		System.out.println(avg);

	}
}

// 하나의 객체 안에 여러 타입 필드가 있는 경우
// 객체 → 객체(String 등) 는 map 사용
// 객체 → 숫자(int, long, double)는 mapToInt, mapToLong, mapToDouble 사용
// 숫자 계산(평균, 합계)는 mapTo~ 필수 사용이다.
// mapTo~는 “객체에서 숫자 필드만 뽑아 계산할 때” 쓰는 것이다
