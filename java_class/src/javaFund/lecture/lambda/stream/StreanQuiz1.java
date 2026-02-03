package java_Fund.lambda.stream;

import java.util.Arrays;
import java.util.List;

/*
 * List에 저장되어 있는 String 요소에서 대소문자와 상관없이
 * java라는 단어가 포함된 영문자만 필터링해서 출력할 거임.
 * 빈칸에 코드를 채우기*/

// contains
// 컨트롤 쉬프트 o
public class StreanQuiz1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a Java class", "Lambda 표현식을 배웁니다.", "Java8부터 람다가 지원됩니다.");
		list.stream()
		.filter(str -> str.toLowerCase().contains("java"))
		.forEach(value -> System.out.println(value));

	}

}
