import java.util.Arrays;
import java.util.Scanner;

//입력 받고 소팅해서 뒤에서 몇개 빼서 가져가면됨

public class swea_6719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int num = sc.nextInt();

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);
			float result = 0;
			for (int i = N - num; i < N; i++) {
				result += arr[i];
				result = result / 2;
			}
			System.out.println("#" + tc + " " + result);
		}

	}

}
