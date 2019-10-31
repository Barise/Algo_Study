import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2105 {
	static int N;
	static int[][] arr;
	static int sr, sc;
	static int result;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result=-1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sr = i;
					sc = j;
					// 좌표,방향,스탭
					dfs(i, j, 0, 0, new boolean[101]);
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void dfs(int r, int c, int dir, int step, boolean[] visit) {
		// 돌아왔다면
		if (step > 3 && sr == r && sc == c) {
			result = Math.max(step, result);
			return;
		}
		for (int i = dir; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			if (check(nr, nc) && !visit[arr[nr][nc]]) {
				visit[arr[nr][nc]] = true;
				//i가지고 가는게 중요! 현재 방향 그대로 들고가는거임
				dfs(nr, nc, i, step + 1, visit);
				visit[arr[nr][nc]] = false;
			}else {
				continue;
			}
		}

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}