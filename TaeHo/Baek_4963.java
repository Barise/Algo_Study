import java.util.*;
import java.io.*;

public class Baek_4963 {
	static int N, M;
	static int[][] arr;
	//대각선생각! 상하좌우 왼쪽위 오른쪽위 왼쪽아래 오른쪽 아래
	static int[] dr = { -1, 1, 0, 0,-1,-1,1,1};
	static int[] dc = { 0, 0, -1, 1,-1,1,-1,1};
	static int count_land;
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = 1;
		M = 1;

		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();
			if(N==0 && M ==0) {
				break;
			}
			arr = new int[N][M];
			visited = new boolean[N][M];
			//입력받구
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						count_land++;
						visited[i][j]=true;
						dfs(i, j);
					}
				}
			}
			System.out.println(count_land);
			count_land=0;
		}
	}

	private static void dfs(int r, int c) {
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(check(nr,nc) && arr[nr][nc]==1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}

	private static boolean check(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr>=0 && nc>=0 && nr<N && nc<M;
	}

}
