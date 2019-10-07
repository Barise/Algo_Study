import java.io.*;
import java.util.*;

//������ȣ���̱�
//25��

public class Baek_2667 {
	//�迭ũ�� ���� N
	static int N;
	//��ü �Է¹迭
	static int[][] arr;
	//ī��Ʈ�� ���� ����
	static ArrayList<Integer> list;
	//���Ž��(�����¿�)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	//���� ũ�� ī��Ʈ
	static int count;

	public static void main(String[] args) throws Exception {
		// dfs�� �Ѵٰ� ����
		// 1������ dfs ȣ��
		// count�� ����Ʈ ����
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
		//����
		solution();
		//���� ���� ���
		System.out.println(list.size());
		//����Ʈ���ִ°� ���
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void solution() {
		// TODO Auto-generated method stub
		//1�� ã���� -> ������ ã����
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					//0���� �ٲ�
					//check �迭�� ���� ������� �ʾƵ� ��
					arr[i][j] = 0;
					//���� ã��
					dfs(i, j);
					//���� ũ�� �߰�
					list.add(count);
					//count �ʱ�ȭ
					count = 1;
				}
			}
		}
		//�������� ����
		Collections.sort(list);
	}

	private static void dfs(int i, int j) {
		//���Ž��
		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			//���ѱ��� �ȿ��ְ�, arr�� 1�̸�
			if (check(nr, nc) && arr[nr][nc] == 1) {
				//������ 0���� ����-> check�迭 �Ⱦ�
				arr[nr][nc] = 0;
				//���� ũ�� 1����
				count++;
				//���
				dfs(nr, nc);
			}
		}
	}
	
	//���� ũ�� ����
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}