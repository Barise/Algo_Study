import java.io.*;

import java.util.*;

 

public class Baek_2564 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int dir = 0;
		int loc = 0;
		int[][] arr = new int[N+1][M+1];
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			loc = Integer.parseInt(st.nextToken());
			if (dir == 1) {
				arr[0][loc] = idx;
				idx++;
			} else if (dir == 2) {
				arr[N - 1][loc-1] = idx;
				idx++;
			} else if (dir == 3) {
				arr[loc][0] = idx;
				idx++;
			} else if (dir == 4) {
				arr[loc][M - 1] = idx;
				idx++;
			}
		}
		for (int i = 0; i <= N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		st = new StringTokenizer(br.readLine());
		dir = Integer.parseInt(st.nextToken());
		loc = Integer.parseInt(st.nextToken())-1;

		int count = 1;
		int[] cnt_arr = new int[N];
		// 상점찾기
		// 시계방향으로 돌리기
		// 동구가 북쪽
		if (dir == 1) {
			// 북쪽
			for (int i = loc; i < M; i++) {
				// 카운트 증가하고
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.max(cnt_arr[arr[0][i]], count);
				}
				count++;
				System.out.println(count);
			}
			// 동쪽
			for (int i = 0; i < N; i++) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.max(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
			// 남쪽
			for (int i = 0; i < M; i++) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.max(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
			// 서쪽
			for (int i = 0; i < N; i++) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.max(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
			// 북쪽
			for (int i = 0; i < loc; i++) {
				// 카운트 증가하고
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.max(cnt_arr[arr[0][i]], count);
				}
				count++;
			}
		}
		// 동구가 남쪽
		else if (dir == 2) {
			// 남쪽
			for (int i = loc; i >= 0; i--) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.max(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
			// 서쪽
			for (int i = 0; i < N; i++) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.max(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
			// 북쪽
			for (int i = 0; i < M; i++) {
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.max(cnt_arr[arr[0][i]], count);
					System.out.println(count);
				}
				// 카운트 증가하고
				count++;
			}
			// 동쪽
			for (int i = 0; i < N; i++) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.max(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
			// 남쪽
			for (int i = M - 1; i >= loc; i--) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.max(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
		}
		// 동구가 서쪽
		else if (dir == 3) {
			// 서쪽
			for (int i = loc; i >= 0; i--) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.max(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
			// 북쪽
			for (int i = 0; i < M; i++) {
				// 카운트 증가하고
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.max(cnt_arr[arr[0][i]], count);
				}
				count++;
			}
			// 동쪽
			for (int i = 0; i < N; i++) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.max(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
			// 남쪽
			for (int i = 0; i < M; i++) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.max(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
			// 서쪽
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.max(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
		}
		// 동구가 동쪽
		else if (dir == 4) {
			// 동쪽
			for (int i = loc; i < N; i++) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.max(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
			// 남쪽
			for (int i = M - 1; i >= 0; i--) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.max(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
			// 서쪽
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.max(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
			// 북쪽
			for (int i = 0; i < M; i++) {
				// 카운트 증가하고
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.max(cnt_arr[arr[0][i]], count);
				}
				count++;
			}
			// 동쪽
			for (int i = 0; i <= loc; i++) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.max(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
		}
		// 반시계로 돌리기
		// 동구가 북쪽
		if (dir == 1) {
			// 북쪽
			for (int i = loc; i >= 0; i--) {
				// 카운트 증가하고
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.min(cnt_arr[arr[0][i]], count);
				}
				count++;
			}
			// 서쪽
			for (int i = 0; i < N; i++) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.min(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
			// 남쪽
			for (int i = 0; i < M; i++) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.min(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
			// 동쪽
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.min(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
			// 북쪽
			for (int i = M - 1; i >= loc; i--) {
				// 카운트 증가하고
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.min(cnt_arr[arr[0][i]], count);
				}
				count++;
			}
		}
		// 동구가 남쪽
		else if (dir == 2) {
			// 남쪽
			for (int i = loc; i < M; i++) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.min(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
			// 동쪽
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.min(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
			// 북쪽
			for (int i = M - 1; i >= 0; i--) {
				// 카운트 증가하고
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.min(cnt_arr[arr[0][i]], count);
				}
				count++;
			}
			// 서쪽
			for (int i = 0; i < N; i++) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.min(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
			// 남쪽
			for (int i = 0; i <loc; i++) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.min(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
		}
 
		// 동구가 서쪽
		else if (dir == 3) {
			// 서쪽
			for (int i = loc; i <M; i++) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.min(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
			// 남쪽
			for (int i = 0; i < M; i++) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.min(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
			// 동쪽
			for (int i = N-1; i >=0; i--) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.min(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
			// 북쪽
			for (int i = M-1; i >=0; i--) {
				// 카운트 증가하고
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.min(cnt_arr[arr[0][i]], count);
				}
				count++;
			}
			// 서쪽
			for (int i = 0; i <loc; i++) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.min(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
		}
 
		// 동구가 동쪽
		else if (dir == 4) {
			// 동쪽
			for (int i = loc-1; i >=0; i--) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.min(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
			// 북쪽
			for (int i = M-1; i >=0; i--) {
				// 카운트 증가하고
				// 상점 찾으면 카운트를 넣어줌
				if (arr[0][i] != 0) {
					cnt_arr[arr[0][i]] = Math.min(cnt_arr[arr[0][i]], count);
				}
				count++;
			}
			// 서쪽
			for (int i = 0; i <M; i++) {
				if (arr[i][0] != 0) {
					cnt_arr[arr[i][0]] = Math.min(cnt_arr[arr[i][0]], count);
				}
				count++;
			}
			// 남쪽
			for (int i = 0; i <M; i++) {
				if (arr[N - 1][i] != 0) {
					cnt_arr[arr[N - 1][i]] = Math.min(cnt_arr[arr[N - 1][i]], count);
				}
				count++;
			}
			// 동쪽
			for (int i = M-1; i > loc; i--) {
				if (arr[i][M - 1] != 0) {
					cnt_arr[arr[i][M - 1]] = Math.min(cnt_arr[arr[i][M - 1]], count);
				}
				count++;
			}
		}

		System.out.println(Arrays.toString(cnt_arr));
		// 동구의 위치에 따라서
	}
}