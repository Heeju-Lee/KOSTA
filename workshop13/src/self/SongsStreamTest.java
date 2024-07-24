package self;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SongsStreamTest {

	public static void main(String[] args) {
		List<Song> songs=new Songs().getSongs();
		
		/*
		 1.  수집하기 - 중간처리 filter | 최종처리 collect
			 스트림으로 만들어서 함수 적용
			 노래의 쟝르 중에서 Rock인 쟝르만 추출
			 정보를 출력한다.
		*/		
		System.out.println("\n=================1번결과=================\n");
		List<Song> rockSong = songs.stream()
				.filter(i -> i.getGenre().equals("Rock"))
				.collect(Collectors.toList());
		System.out.println(rockSong);
		
		/*
		  2.  존재여부 확인하기 - 최종처리 anyMatch
		      노래의 장르중에서 R&B장르가 있는지 여부를 확인하고 출력한다.
		 */		
		System.out.println("\n=================2번결과=================\n");
		boolean result = songs.stream()
				.anyMatch(i->i.getGenre().equals("R&B"));
			
				System.out.println(result);
				
		
		 /*
		   3.  항목 갯수세기 - 중간 처리 map, peek, distinct | 최종 처리 count
		       아티스트정보 만으로 새로운 스트림을 만들고 
		       정보들을 뽑아서 먼저 중간출력을 해본다.
		       중복된 정보들이 있으면 제거하고
		       아티스트 갯수를 출력한다.		       
		 */		
		System.out.println("\n=================3번결과=================\n");				
		 long result1 = songs.stream()
				 .map(i->i.getArtist())
				 .distinct()
				 .peek(i->System.out.println(i))
				 .count();
				 System.out.println(result1);
		
		 /*
		    4. 1995년도에 발매된 노래만 추출해서 그 중에서 첫번째 노래를 찾아서 정보를 출력
		 */
		System.out.println("\n=================4번결과.Optional 1 사용=================\n");
		Optional<Song> issued1995First1 = songs.stream()
				.filter(i -> i.getYear()== 1995)
				.findFirst();
				System.out.println(issued1995First1);
				
		System.out.println("\n=================4번결과.Optional 2 사용=================\n");
				
		Optional<Song> issued1995First2 = songs.stream()
				.filter(i -> i.getYear()== 1995)
				.findFirst();
		if(issued1995First2.isPresent())
			System.out.println(issued1995First2.get());
		else 
			System.out.println("해당 년도의 노래는 찾을수 없습니다.");
				
				

		
		
		System.out.println("\n=================4번결과.forEach 사용=================\n");
						
		songs.stream()
				.filter(i -> i.getYear()== 1995)
				.limit(1)
				.forEach(System.out::print);//void 반환, Stream은 void를 반환할 수 업다.
				
				
	}
}







