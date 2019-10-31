import java.util.Arrays;
import java.util.Scanner;

public class Baek_1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Num = sc.nextInt();

		float[] arr = new float[Num];

		for (int i = 0; i < Num; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		float result = 0;
		float temp =0;
		for (int i = 0; i < Num; i++) {
			temp = (arr[i]/arr[Num-1])*100;
			result+=temp;
		}
		System.out.println(result/Num);
	}

}
