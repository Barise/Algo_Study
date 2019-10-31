import java.io.*;
import java.util.*;

//토마토

//아니 이거 list로 어케푸냐 
//list 나 queue로 풀면 편할꺼같은데
//코드가 도저히안나오네..
//

//그냥 순회하면서 1이고 방문안한거
//상하좌우1로바꾸고 -1이면 냅두고
//매번 검사해서 바뀌는게 없으면 안되는거니까 -1출력
//매번 검사에서 다 -1을 제외하고 다 1이면 카운트 한거 출력
//내시간...

public class Baek_7576 {
	static int[][] arr;
	static int[][] clone_arr;
	static int N, M, count_Day;
	static boolean[][] visited = new boolean[N][M];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		clone_arr = new int[N][M];
		String str = "";
		count_Day = 0;
		int minus_one_count =0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==-1) {
					minus_one_count++;
				}
				arr[i][j] = Integer.parseInt(st.nextToken());
				clone_arr[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		int sum = 0;
		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < args.length; j++) {
					arr[i][j] = clone_arr[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1) {
						sum += arr[i][j];
					}
				}
			}
			if(sum==(N*M-minus_one_count)) {
				break;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1) {
						if (visited[i][j]) {
							continue;
						} else {
							visited[i][j]=true;
							for (int i1 = 0; i1 < 4; i++) {
								int nr = i + dr[i1];
								int nc = j + dc[i1];
								if (check(nr, nc) && arr[nr][nc] == 0 && !visited[nr][nc]) {
									clone_arr[nr][nc] = 1;
									visited[nr][nc] = true;
								}
							}
						}
					}
				}
			}
			count_Day++;
		}
		System.out.println(count_Day);
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}