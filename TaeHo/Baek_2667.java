import java.io.*;
import java.util.*;

//단지번호붙이기
//25분

public class Baek_2667 {
	//배열크기 받을 N
	static int N;
	//전체 입력배열
	static int[][] arr;
	//카운트한 단지 저장
	static ArrayList<Integer> list;
	//사방탐색(상하좌우)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	//단지 크기 카운트
	static int count;

	public static void main(String[] args) throws Exception {
		// dfs만 한다고 생각
		// 1만나면 dfs 호출
		// count할 리스트 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// init
		arr = new int[N][N];
		list = new ArrayList<>();
		//input
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		count = 1;
		//로직
		solution();
		//단지 개수 출력
		System.out.println(list.size());
		//리스트에있는거 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void solution() {
		// TODO Auto-generated method stub
		//1을 찾으면 -> 단지를 찾으면
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					//0으로 바꿈
					//check 배열을 굳이 사용하지 않아도 될
					arr[i][j] = 0;
					//단지 찾기
					dfs(i, j);
					//단지 크기 추가
					list.add(count);
					//count 초기화
					count = 1;
				}
			}
		}
		//오름차순 정렬
		Collections.sort(list);
	}

	private static void dfs(int i, int j) {
		//사방탐색
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			//제한구역 안에있고, arr가 1이면
			if (check(nr, nc) && arr[nr][nc] == 1) {
				//단지를 0으로 만듬-> check배열 안씀
				arr[nr][nc] = 0;
				//단지 크기 1증가
				count++;
				//재귀
				dfs(nr, nc);
			}
		}
	}
	
	//제한 크기 설정
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}