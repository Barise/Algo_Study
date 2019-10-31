import java.util.Scanner;

//의석이의 우뚝 선 산
public class SW_5356 {
	static int N;
	static int[] arr;
	static int[] dc = { -1, 1 };
	static int count;
	static int left_count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			left_count = 1;
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 1; i < N - 1; i++) {
				int temp = arr[i];
				count = 1;
				left_count=0;
				dfs(i);
				if (count > 3) {
					count-=2;
					for (int j = i - 1; j >= 0; j--) {
						if (temp < arr[j]) {
							break;
						} else if (temp > arr[j]) {
							temp=arr[j];
							left_count++;
						}
					}					
					result += (left_count) * (count - left_count + 1);
				}
				else if(count ==3) {
					result+=1;
				}
				
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	private static void dfs(int c) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			int nc = c + dc[i];
			if (check(nc) && arr[nc] < arr[c]) {
				dfs(nc);
				count++;
			}
		}
	}

	private static boolean check(int c) {
		// TODO Auto-generated method stub
		return c >= 0 && c < N;
	}
}
