//아기상어

import java.io.*;
import java.util.*;

//현재 아기상어의 위치를 큐에 넣고, BFS탐색을 시작
//먹을 수 있는 물고기가 있으면, 해당 좌표와 거리를 먹이큐(우선순위)에 저장
//먹을 수 있는 물고기가 또 나왔는데, 마지막에 저장한 거리보다 더 큰 거리이면 그만찾자.
//먹이큐에서 물고기를 꺼내서, 먹고 마리수 증가 및 레벨증가 처리, 그리고 그 먹이까지 이동한 거리를 정답에 누적합
//먹이큐에서 물고기가 안나오면 종료

public class Baek_16236 {
	static int N;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static Queue<fish> q = new LinkedList<>();
	static ArrayList<fish> list = new ArrayList<>();

	static int X = 0;
	static int Y = 0;
	static int cnt;
	static int lev = 2;
	static int ans;
	static class fish implements Comparable<fish>{
		int r;
		int c;
		int dist;

		public fish(int x, int y, int dist) {
			this.r = x;
			this.c = y;
			this.dist = dist;
		}


		@Override
		public int compareTo(fish o) {
			
			if(this.dist == o.dist) {
				if(this.r == o.r)
					return Integer.compare(this.c, o.c);
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.dist, o.dist);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					X = i;
					Y = j;
					// 위치는 기억하고 맵에는 지워버리자!
					arr[i][j] = 0;
				}
			}
		}
	
	
	
		while(true) {
			PriorityQueue<fish> feed = new PriorityQueue<>();//먹이 큐
			Queue<fish> queue = new LinkedList<>(); //아기상어의 이동 큐
			//한 루프 마다 새로운 이동이므로 새 방문배열을 준비
			visited = new boolean[N][N];
			//현재 아기상어의 위치를 큐에 넣어줌
			queue.add(new fish(X, Y, 0));
			visited[X][Y] = true;
			int dist = 987654321;
			while( !queue.isEmpty()) {
				fish fish = queue.poll();
				//아기상어가 이번에 위치한 자리가, 먹을 수 있는 먹이자리이면, 먹이큐에 추가
				if( arr[fish.r][fish.c] != 0 && arr[fish.r][fish.c] < lev ) {
					dist = fish.dist;
					feed.add(fish);
				}
				//마지막에 먹었던 먹이의 거리보다 더 먼 거리의 먹이가 발견되면 그만 탐색
				if( dist < fish.dist )
					break;
				for (int i = 0; i < 4; i++) {
					int nr = fish.r + dr[i];
					int nc = fish.c + dc[i];
					if(check(nr,nc) && !visited[nr][nc] && arr[nr][nc] <= lev) {
						visited[nr][nc] =true;
						queue.add(new fish(nr, nc, fish.dist+1));
					}
				}
			}
			fish f = feed.poll();
			//먹이가 없으면 종료
			if(f ==null){
				break;
			}
			//먹이를 맵에서 지워주고
			arr[f.r][f.c] =0;
			//아기 상어의 위치를 먹이의 위치로 이동
			X =f.r;
			Y = f.c;
			//먹이 카운트 1증가
			cnt++;
			if(cnt ==lev) {
				lev++;
				cnt =0;
			}
			//먹이까지 이동한 거리를 정답에 누적합
			ans +=f.dist;
		}
		System.out.println(ans);
		// 거리찾자
//		q.add(new fish(X, Y, 0));
//		visited[X][Y] = true;
//		while (!q.isEmpty()) {
//			cnt++;
//			fish f = q.poll();
//			int r = f.x;
//			int c = f.y;
//			int dist = f.dist;
//
//			for (int i = 0; i < 4; i++) {
//				int nr = r + dr[i];
//				int nc = c + dc[i];
//				if (check(nr, nc) && arr[nr][nc] == 0 && !visited[nr][nc]) {
//					System.out.println("---");
//					visited[nr][nc] = true;
//					q.add(new fish(nr, nc, dist + 1));
//				}
//				// 방문체크가 되있는건 아기상어뿐
//				if (check(nr, nc) && arr[nr][nc] != 0) {
//					list.add(new fish(nr, nc, dist + 1));
//				}
//			}
//		}
		
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}
