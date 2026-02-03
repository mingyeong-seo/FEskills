package java_Fund.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEx4 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();

		list.add(new Student("홍길동", 85, "여"));
		list.add(new Student("아이언맨", 90, "여"));
		list.add(new Student("가나디", 95, "여"));
		list.add(new Student("망곰", 100, "남"));
		
		// 남학생만 추출해서 malelist라는 ArrayList에 담기 
		List<Student> maleList = new ArrayList<Student>();
		
		
		for(Student student : list) { // for (타입 변수 : 컬렉션)
			if(student.getSex().equals("남"))
				maleList.add(student);
		}
		
		// collect()를 이용한 집계 
		List<Student> maleList2 = list.stream()
				.filter(student -> student.getSex().equals("남"))
				.collect(Collectors.toList()); // 스트림에서 흘러나온 요소들을 “어디에 모을지(수집할지)” 정하는 연산
											   //Collectors.toList()는 스트림의 요소들을 List로 모아라 라는 수집 규칙 => 결과를 List에 담아줘
		System.out.println(maleList2);
		
		List<Student> maleList3 = list.stream()
				.filter(student -> student.getSex().equals("남"))
				.toList();
		
		// Map 형태로 변형도 가능함
		Map<String, Integer> map = list.stream()
				.collect(Collectors.toMap(t->t.getName(), t-> t.getScore()));
				
		System.out.println(map);

	
	}

}
//filter = 걸러내기
//map = 모양 바꾸기
//collect = 모으기
// map(입력 -> 출력)
