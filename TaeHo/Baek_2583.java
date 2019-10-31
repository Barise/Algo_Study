import java.io.*;
import java.util.*;

public class Baek_2583 {
	static int N, M, K;
	static int[][] arr;
	static boolean[][] isUse;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Integer> list;
	static int cnt = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[M][N];
		isUse = new boolean[M][N];
		int result = 0;
		list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int start_X = Integer.parseInt(st.nextToken());
			int start_Y = Integer.parseInt(st.nextToken());
			int end_X = Integer.parseInt(st.nextToken());
			int end_Y = Integer.parseInt(st.nextToken());

			for (int j = start_X; j < end_X; j++) {
				for (int j2 = start_Y; j2 < end_Y; j2++) {
					arr[j][j2] = 1;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0 && !isUse[i][j]) {
					arr[i][j]=1;
					isUse[i][j] = true;
					dfs(i, j);
					result++;
					list.add(cnt);
					cnt = 1;
				}
			}
		}
		
		
		System.out.println(result);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}

	private static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (check(nr, nc) && !isUse[nr][nc] && arr[nr][nc] == 0) {
				isUse[nr][nc] = true;
				arr[nr][nc] = 1;
				cnt++;
				dfs(nr, nc);
			}
		}
	}

	private static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<M && nc<N;
	}
}