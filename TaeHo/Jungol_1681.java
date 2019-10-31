import java.util.Arrays;
import java.util.Scanner;

//해밀턴 순환회로
public class Jungol_1681 {
	static boolean[] visit;
	static int N, result = 1234567891;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		visit = new boolean[N];
		dfs(0, 1, 0);

		System.out.println(result);
	}

	private static void dfs(int sum, int count, int r) {
		if (N == count) {
			if (arr[r][0] != 0) {
				sum += arr[r][0];
				result = Math.min(sum, result);
			}
			return;
		}

		for (int i = 1; i < N; i++) {
			// 방문하지 않않고 그 값이 0이 아니라면
			if (!visit[i] && arr[r][i] != 0) {
				visit[i] = true;
				dfs(sum + arr[r][i], count + 1, i);
				visit[i] = false;
			}

		}
	}
}
