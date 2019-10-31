import java.util.*;
import java.io.*;
//연구소

//모든 0중에서 3개를 골라서 1로 만들고
//2를 찾아서 1로 막힐때까지 전부 2로 만듬

// 그때의 0을 카운트
// 반복해서 0의 개수중에 가장 큰것을 찾음

public class Baek_14502 {
	static int[][] arr;
	static int N, M;
	static boolean[][] visited;
	static int result;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int count = 0;
	static int[][] origin_arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		origin_arr = new int[N][M];
		// input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				origin_arr[i][j] = arr[i][j];
			}
		}

		// 0중에 3개를 뽑음
		dfs(0);
		System.out.println(result);
	}

	private static void dfs(int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					origin_arr[i][j] = arr[i][j];
				}
			}

			// 2를 찾아서 1로 막힐때까지 전부 2로만듬
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 2) {

						dfs_two(i, j);
					}
				}
			}
//			// 전부 2로만듬
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] && arr[i][j] == 0) {
						arr[i][j] = 2;
					}
				}
			}
//			 그때의 0을 카운트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0) {
						count++;
					}
				}
			}
//			 큰거 찾아서
			result = Math.max(result, count);
			count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = origin_arr[i][j];
					visited[i][j] = false;
				}
			}

			return;
		}

		// 재귀
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					visited[i][j] = true;
					dfs(cnt + 1);
					arr[i][j] = 0;
					visited[i][j] = false;
				}
			}
		}
	}

	private static void dfs_two(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (check(nr, nc) && arr[nr][nc] == 0 && arr[nr][nc] != 1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs_two(nr, nc);
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}