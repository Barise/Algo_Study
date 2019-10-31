import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//N은 배열의 크기
//M은 묘목의 개수
//인풋은 K년 지난후 살아남은 나무의 개수

public class Baek_16235_2 {
	static int N, M, K;
	static int[][] save; // 추가되는 양분 저장용
	static int[][] arr; // 양분
	// 8방탐색
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	//
	static Queue<tree> dead = new LinkedList<tree>();
	static PriorityQueue<tree> q = new PriorityQueue<tree>();;
	static Queue<tree> tmpq = new LinkedList<tree>();

	public static void main(String[] args) throws IOException {
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
		for (int i = 1; i <= N; i++) {
			System.out.println(Arrays.toString(save[i]));
		}
		
		for (int i = 0; i < M; i++) { // r c age
			str = br.readLine();
			st = new StringTokenizer(str);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			// 좌표랑 나이를 우선순위 큐에 넣어주고 정렬함
			q.add(new tree(r, c, age));
			// 나이로 정렬된 tree객체가 있음
		}
		//몇년 지났는지 체크하는 배열
		int year = 0;
		while (year < K) {
			// 봄
			// 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
			// 같은 1×1 크기의 칸에 여러 개의 나무가 심어져 있을 수도 있다.
			// 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
			//사이즈를 저장
			int size = q.size();
			//pq의 사이즈 만큼
			//순서대로 다 해야하니까 이렇게! 
			//다음껏들은 다 죽임
			for (int i = 0; i < size; i++) {
				//하나를 뺴서 
				tree t = q.poll();
				//좌표 받고
				int r = t.r;
				int c = t.c;
				int age = t.age;
				// System.out.println("age" + age);
				// 이나무의 위치에 양분이 age만큼 있느냐 없느냐.
				//해당 좌표가의 양분이 나이보다 많으면
				if (arr[r][c] >= age) {
					//양분을 뺴준다음
					arr[r][c] = arr[r][c] - age; // 나무의 나이증가.
					//나이를 증가시켜서 tempq에 저장
					tmpq.add(new tree(r, c, age + 1));
				} else { // 나무가 죽었따면???
					dead.add(new tree(r, c, age));
				}
			}

			// 여름
			// 죽은 나무들이 자기나이/2가 되어 양분으로 추가된다.
			//죽은 나무들의 사이즈를 저장
			size = dead.size();
			//그 죽은나무의 사이즈 만큼
			for (int i = 0; i < size; i++) {
				//하나뺴서
				tree t = dead.poll();
				//좌표,나이 잡고
				int r = t.r;
				int c = t.c;
				int age = t.age;
				//그 절반은 해당 좌표에 넣어줌
				arr[r][c] += (age / 2);
			}
			// 가을에는 나무가 번식.. 8개의칸에 나이가 1인 나무가 생김..
			// 조건은 나이가 5로 나누어 떨어짐.
			//살아있는 나무들이 저장된 큐의 사이즈 만큼!!!!
			size = tmpq.size();
			for (int i = 0; i < size; i++) {
				tree t = tmpq.poll();
				int r = t.r;
				int c = t.c;
				int age = t.age;
				//만약 나이가 5의 배수라면
				if (age % 5 == 0) {
					//8방향에 다 넣어줌
					for (int p = 0; p < 8; p++) {
						int nr = r + dr[p];
						int nc = c + dc[p];
						if (valid(nr, nc)) {
							q.add(new tree(nr, nc, 1));
						}
					}
				} // 5로 나누어떨어지지않으면 그냥 다시 넣자.
					// 본인위치 또 넣기
				q.add(t);
			}
			// 겨울에는 양분이 추가된다.
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = arr[i][j] + save[i][j];
				}
			}

			year++;
			if (year == K) {
				break;
			}
		}
		System.out.println(q.size());
	}

	static boolean valid(int i, int j) {
		return i > 0 && j > 0 && i <= N && j <= N;
	}

	static class tree implements Comparable<tree> {
		// 좌표랑
		int r, c;
		// 나이
		int age;

		public tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		// 나이로 정렬
		@Override
		public int compareTo(tree o) {
			return this.age - o.age;
		}
	}
}