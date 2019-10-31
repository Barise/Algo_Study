import java.io.*;
import java.util.*;

//NXN크기의 땅
//r은 row c는 column을 말함, r과 c는 1부터 시작한다.
//모든 칸엔 5가 저장되어있음
//한칸에 여러개의 묘목이 심어질수있음
//봄에는 여러개의 묘목이 있을때 가장 나이가 어린 애부터 양분을 먹음, 나이가 1증가
//나이 만큼의 양분을 먹지못하면 즉시 죽음
//여름에는 봄에 죽은 나무가 양분으로 변함
// 나이/2 값이 해당칸의 양분에 추가
//가을에는 나무가 번식, 나무의 나이가 5의 배수일때 인접한 8개 칸에 나무1개씩 생김
//겨울에는 땅에양분을 챙김 각칸에 추가되는 양분은 A[r][c]
//

//좌표랑 나이받을 큐하나 생성
//

public class Baek_16235 {
	static int N, M, K;
	static int[][] save;
	static int[][] arr;
	static Queue<tree> liveQ = new LinkedList<>();
	static Queue<tree> deadQ = new LinkedList<>();
	static PriorityQueue<tree> pq = new PriorityQueue<>();
	// 8방탐색
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	// 정렬
	static public class tree implements Comparable<tree> {
		int r;
		int c;
		int age;

		public tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		save = new int[N + 1][N + 1];
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 1; j <= N; j++) {
				save[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) { // r c age
			str = br.readLine();
			st = new StringTokenizer(str);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			// 좌표랑 나이를 우선순위 큐에 넣어주고 정렬함
			pq.add(new tree(r, c, age));
			// 나이로 정렬된 tree객체가 있음
		}
		int year = 0;

		while (year < K) {
			// 봄
			// 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
			// 같은 1×1 크기의 칸에 여러 개의 나무가 심어져 있을 수도 있다.
			// 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
			// 사이즈를 저장
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				// age로 정렬이 되있는 애가 나옴
				tree t = pq.poll();
				int r = t.r;
				int c = t.c;
				int age = t.age;
				// 모들어가면 죽은거
				if (arr[r][c] >= age) {
					arr[r][c] = arr[r][c] - age;
					liveQ.add(new tree(r, c, age + 1));
				} else {
					deadQ.add(new tree(r, c, age));
				}
			}

			// 여름
			// 죽은 나무들이 자기나이/2가 되어 양분으로 추가된다.
			// 죽은 나무들의 사이즈를 저장
			size = deadQ.size();
			for (int i = 0; i < size; i++) {
				tree t = deadQ.poll();
				int r = t.r;
				int c = t.c;
				int age = t.age;
				arr[r][c] += age / 2;
			}

			// 가을에는 나무가 번식.. 8개의칸에 나이가 1인 나무가 생김..
			// 조건은 나이가 5로 나누어 떨어짐.
			// 살아있는 나무들이 저장된 큐의 사이즈 만큼!!!!
			size = liveQ.size();
			for (int i = 0; i < size; i++) {
				tree t = liveQ.poll();
				int r = t.r;
				int c = t.c;
				int age = t.age;
				if (age % 5 == 0) {

					for (int j = 0; j < 8; j++) {
						int nr = r + dr[j];
						int nc = c + dc[j];
						// 범위 안에 있으면
						if (check(nr, nc)) {
							pq.add(new tree(nr, nc, 1));
						}
					}
				}
				// 본인도 다시 들어가고!
				pq.add(t);
			}

			// 겨울에는 양분이 추가된다.
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] += save[i][j];
				}
			}

			year++;
			if (year == K) {
				break;
			}
		}
		System.out.println(pq.size());
	}

	private static boolean check(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 1 && nc >= 1 && nr <= N && nc <= N;
	}

}
