//¿Ø±‚≥ÛπË√ﬂ

import java.util.Scanner;

public class Baek_1012 {
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int count = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			arr = new int[M][N];
			int Num = sc.nextInt();
			for (int i = 0; i < Num; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				arr[n2][n1] = 1;
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						count ++;
						arr[i][j]=0;
						dfs(i, j, M, N);
					}
				}
			}
			System.out.println(count);
		}

	}

	private static void dfs(int i, int j, int M, int N) {
		// TODO Auto-generated method stub
		if (i - 1 >= 0 && arr[i - 1][j] == 1) {
			arr[i - 1][j] = 0;
			dfs(i - 1, j, M, N);
		}
		if (j - 1 >= 0 && arr[i][j - 1] == 1) {
			arr[i][j - 1] = 0;
			dfs(i, j - 1, M, N);
		}
		if (j + 1 < N && arr[i][j + 1] == 1) {
			arr[i][j + 1] = 0;
			dfs(i, j + 1, M, N);
		}
		if (i + 1 < M && arr[i + 1][j] == 1) {
			arr[i + 1][j] = 0;
			dfs(i + 1, j, M, N);
		}
	}
}