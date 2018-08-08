import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelMain {

	public static void work(int a) {
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		int[] ar = { 20, 30, 75, 30, 45, 56, 67, 78 };

		// �Ϲ� ��Ʈ������ work �۾��� ����
		IntStream stream = Arrays.stream(ar);
		long start = System.currentTimeMillis();
		stream.forEach(su -> work(su));
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		// �Ϲ� ��Ʈ������ work �۾��� ����
		stream = Arrays.stream(ar);
		start = System.currentTimeMillis();
		stream.parallel().forEach(su -> work(su));
		end = System.currentTimeMillis();
		System.out.println(end - start);

	}

}
