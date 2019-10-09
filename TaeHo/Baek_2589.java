import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//보물섬

//기존 아이디어
//종단을 먼저 찾음
//종단 : L인 점을 찾아서 4방향중에 L이 1개만 있으면 거기는 종단이라고 생각
//종단인 지점들을 찾아서
//서로간에 DFS해서 값을 출력

// 문제점 : 최단거리문제에서 DFS를 생각한게 잘못 - 시간초과 나옴
// + 덧붙여서 저게 종단이라는가정또한 문제 

//다른 아이디어

// L을 찾아서 BFS를 이용해서 모든 지점에서 대해서 count 해서 count_arr배열에 넣어줌
// 그때의 가장 큰값을 저장

//주석 달면서 느낀점
//굳이 이거 카운트 배열하나더 만들 이유가 없었음
//그냥 객체에서 카운트변수 하나 더 들고갔으면 됬음
// 추가로 이거 그냥 인력받을때 L인거 다 리스트에 넣고 foreach 로 돌렸으면
// 최적화도 가능할듯!?!?

public class Baek_2589 {
	//input 배열
	static char[][] arr;
	// 카운트해서 넣을 배열(굳이없어도됨)
	static int[][] count_arr;
	//방문체크 배열
	static boolean[][] isUse;
	//큐생성
	static Queue<Pos> q = new LinkedList<>();
	//상하좌우 사방탐색
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	//배열의 크기, 카운트할 변수, 출력할 최대카운트
	static int N, M, count, max_count;
	//좌표를 입력받을 class 생성
	static class Pos {
		int i;
		int j;

		Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//초기화
		count_arr = new int[N][M];
		arr = new char[N][M];
		isUse = new boolean[N][M];
		//입력
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		max_count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// L을 찾음
				if (arr[i][j] == 'L') {
					//초기화
					for (int init = 0; init < N; init++) {
						Arrays.fill(isUse[init], false);
						Arrays.fill(count_arr[init], 0);
					}
					//큐를 비움
					q.clear();
					//찾지점을 큐에 넣음
					q.add(new Pos(i, j));
					//방문체크 true
					isUse[i][j] = true;
					//count 초기화
					count = 0;
					//큐가 빌때까지
					while (!q.isEmpty()) {
						//처음 지점을 뺌
						Pos p = q.poll();
						//현재 카운트에 있는 값을 카운트변수에넣어줌 
						count = count_arr[p.i][p.j];
						//사방탐색
						for (int k = 0; k < 4; k++) {
							int nr = p.i + dr[k];
							int nc = p.j + dc[k];
							//범위안에있고, L이고 그지점을 방문하지 않았으면
							if (check(nr, nc) && arr[nr][nc] == 'L' && !isUse[nr][nc]) {
								// 방문체크
								isUse[nr][nc] = true;
								//큐에 넣어줌(여기서 카운트변수있으면 늘려주고 생성하면됨)
								q.add(new Pos(nr, nc));
								//카운트 배열 증가(위 주석대로했으면 이줄이 필요가없음)
								count_arr[nr][nc] = count_arr[p.i][p.j] + 1;
							}
						}
					}
					//가장큰값 찾음
					max_count = Math.max(count, max_count);
				}
			}
		}
		
		//출력
		System.out.println(max_count);
	}
	//범위 안에있으면!
	private static boolean check(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}