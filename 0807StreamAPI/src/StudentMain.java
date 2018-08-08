
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
		
		//Stream ����
		Stream<StudentDTO> stream = list.stream();
		
		//�߰�ó�� - �����͸� 2�� �ǳʶٰ� 3�� ���
		//stream.skip(2).limit(3).forEach(data -> System.out.println(data));
		
		//�߰�ó�� - �����ϰ� ����
		//stream.filter(data -> data.getGender().equals("����")).sorted((d1,d2)->d1.getScore()-d2.getScore()).forEach(data ->System.out.println(data));
		
		//����ó�� - ������ ����
		//long cnt = stream.count();
		//System.out.println(cnt);
		
		// Optional�� ���ϵǴ� �����ʹ� �ѹ� �� ������ �ؾ� �մϴ�.-get(), orElse(T default), isPresent()
		//StudentDTO dao = stream.findFirst().get();
		//System.out.println(dao);
		
		//score �հ� ���ϱ� 
		//int sum = stream.mapToInt(StudentDTO :: getScore).sum();
		//System.out.println(sum);
		
		//������ ������ �������� ��� ���� ���ϱ� - �Ҽ� 1�ڸ����� �ݿø�  
		/*double avg = stream
				.filter(data-> data.getGender().equals("����"))
				.mapToInt(StudentDTO::getScore).average().getAsDouble();
		int score = (int)(avg + 0.5);
		System.out.println("���� ��� ����:" + score);*/
		
		// ������ ������ �����͸� ���� ���� - List collect
		/*List <StudentDTO> list = stream.filter(data -> data.getGender().equals("����")).collect(Collectors.toList());
		System.out.println(listc);*/
		
		//Key�� name, value�� score�� ������ ���� - map collect   
		/*Map <String, Integer> map = stream.collect(Collectors.toMap(StudentDTO::getName, data->data.getScore()));
		System.out.println(map);*/
		
		//������ �����̰� score�� 90�̻��� �������� list�� ����
		/*List <StudentDTO> list = stream.filter(data->data.getGender().equals("����") && data.getScore()>=90).collect(Collectors.toList());
		for(StudentDTO s:list1) {
			System.out.println(s);
		}*/
		
		//collect�� groupingBy ���� ���� map
		//key: �׷�ȭ�� getter�Լ��� ���, value: ���� �������� List
		/*Map <String, List<StudentDTO>> map= stream.collect(Collectors.groupingBy(StudentDTO::getGender));
		System.out.println(map);*/
		
		//summarizingInt
		Map<String, IntSummaryStatistics> map= stream.collect(Collectors.groupingBy(StudentDTO::getGender, Collectors.summarizingInt(StudentDTO::getScore)));
		System.out.println(map);
		
		//gender ���� score�� �հ踦 ������ ���
		 /*Map<String, Integer> map= stream.collect(Collectors.groupingBy(StudentDTO::getGender, Collectors.summingInt(StudentDTO::getScore)));
		 System.out.println(map);*/
		
		//Map ������ ���� ���
		 Set<String> keyset = map.keySet();
		 for(String key: keyset) {
			 System.out.println(key + ":"+ map.get(key));
		 }
	}

}
