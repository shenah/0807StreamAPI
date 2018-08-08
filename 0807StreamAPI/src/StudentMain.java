
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentMain {

	public static void main(String[] args) {
		StudentDAO sd = new StudentDAO();
		List <StudentDTO> list = sd.fetch();
		
		//Stream 생성
		Stream<StudentDTO> stream = list.stream();
		
		//중간처리 - 데이터를 2개 건너뛰고 3개 출력
		//stream.skip(2).limit(3).forEach(data -> System.out.println(data));
		
		//중간처리 - 필터하고 정열
		//stream.filter(data -> data.getGender().equals("남자")).sorted((d1,d2)->d1.getScore()-d2.getScore()).forEach(data ->System.out.println(data));
		
		//최종처리 - 데이터 개수
		//long cnt = stream.count();
		//System.out.println(cnt);
		
		// Optional로 리턴되는 데이터는 한번 더 가공을 해야 합니다.-get(), orElse(T default), isPresent()
		//StudentDTO dao = stream.findFirst().get();
		//System.out.println(dao);
		
		//score 합계 구하기 
		//int sum = stream.mapToInt(StudentDTO :: getScore).sum();
		//System.out.println(sum);
		
		//성별이 남자인 데이터의 평균 점수 구하기 - 소수 1자리에서 반올림  
		/*double avg = stream
				.filter(data-> data.getGender().equals("남자"))
				.mapToInt(StudentDTO::getScore).average().getAsDouble();
		int score = (int)(avg + 0.5);
		System.out.println("남자 평균 점수:" + score);*/
		
		// 성별이 여자인 데이터를 전부 수집 - List collect
		/*List <StudentDTO> list = stream.filter(data -> data.getGender().equals("여자")).collect(Collectors.toList());
		System.out.println(listc);*/
		
		//Key가 name, value가 score인 데이터 수집 - map collect   
		/*Map <String, Integer> map = stream.collect(Collectors.toMap(StudentDTO::getName, data->data.getScore()));
		System.out.println(map);*/
		
		//성별이 남자이고 score가 90이상인 데이터의 list를 생성
		/*List <StudentDTO> list = stream.filter(data->data.getGender().equals("남자") && data.getScore()>=90).collect(Collectors.toList());
		for(StudentDTO s:list1) {
			System.out.println(s);
		}*/
		
		//collect의 groupingBy 리턴 값은 map
		//key: 그룹화한 getter함수의 결과, value: 원래 데이터의 List
		/*Map <String, List<StudentDTO>> map= stream.collect(Collectors.groupingBy(StudentDTO::getGender));
		System.out.println(map);*/
		
		//summarizingInt
		Map<String, IntSummaryStatistics> map= stream.collect(Collectors.groupingBy(StudentDTO::getGender, Collectors.summarizingInt(StudentDTO::getScore)));
		System.out.println(map);
		
		//gender 별로 score의 합계를 정수로 출력
		 /*Map<String, Integer> map= stream.collect(Collectors.groupingBy(StudentDTO::getGender, Collectors.summingInt(StudentDTO::getScore)));
		 System.out.println(map);*/
		
		//Map 데이터 전부 출력
		 Set<String> keyset = map.keySet();
		 for(String key: keyset) {
			 System.out.println(key + ":"+ map.get(key));
		 }
	}

}
