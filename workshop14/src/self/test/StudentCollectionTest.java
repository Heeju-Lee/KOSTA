package self.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import self.vo.Student;

public class StudentCollectionTest {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList< >();
		totalList.add(new Student("전현무", "남", 92));
		totalList.add(new Student("한혜진", "여", 87));
		totalList.add(new Student("이장우", "남", 95));
		totalList.add(new Student("박나래", "여", 93));
		
		//1. 남학생만 묶어 List 생성
		System.out.println("\n------------------1. 방법 1------------------\n");	
		List<Student> maleList = totalList.stream()
				.filter(i->i.getGender().equals("남"))
				.collect(Collectors.toList());
				System.out.println(maleList);	
				
		System.out.println("\n------------------1. 방법 2------------------\n");	
		totalList.stream()
				.filter(i->i.getGender().equals("남"))
				.forEach(i->System.out.println(i));
			
		//2. 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기..학생의 이름과 성적을 출력
		System.out.println("\n------------------2. 학생의 이름과 성적 출력(오름차순)------------------\n");	
		totalList.stream()
			.sorted(Comparator.comparingInt(Student::getScore))
			.forEach(i->System.out.println("이름: "+i.getName()+", 성적 :"+i.getScore()));
						
		//3. 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기..학생의 이름과 성적을 출력
		System.out.println("\n------------------3. 학생의 이름과 성적 출력(내림차순)------------------\n");
		totalList.stream()
			.sorted(Comparator.comparingInt(Student::getScore).reversed())
			.forEach(i->System.out.println("이름: "+i.getName()+", 성적 :"+i.getScore()));
						
		System.out.println("\n--------------------------------------\n");
		
		//4. 학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
		//   Collectors.toMap()을 사용
		System.out.println("\n------------------4. 학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성------------------\n");
		Map<String, Integer> map = totalList.stream()
				.collect(Collectors.toMap(Student::getName, Student::getScore));
		System.out.println(map);

	}
}
