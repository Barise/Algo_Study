import java.util.Arrays;
import java.util.Scanner;
//마방진

//왼쪽 현재 위치에서 왼쪽위로가서 값을 찍음
//왼쪽으로 이동, 범위 밖으로 나가면 오른쪽으로 이동
//위로 이동하는데 범위 밖으로 나가면 아래쪽으로 이동

//해당위치에 값이 있으면 원래 위치에서 아래로 내려간 다음 값을 찍음
//

public class hw_ct_1023 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int input_Num = 1;
		int[][] bangJin = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				bangJin[i][j] = sc.nextInt();
			}
		}
		
		
		
		
		
		
		// start위치
//		int x = 1;
//		int y = N / 2 + 1;
//		int temp_x = 1;
//		int temp_y = 1;
//		while (true) {
//			if (input_Num == N * N + 1) {
//				break;
//			}
//			if (bangJin[x][y] == 0) {
//				bangJin[x][y] = input_Num++;
//				temp_x = x;
//				x = x - 1;
//				if (x < 1) {
//					x = N;
//				}
//				temp_y = y;
//				y = y + 1;
//				if (y >= N + 1) {
//					y = 1;
//				}
//			}
//			if (input_Num == N * N + 1) {
//				break;
//			}
//			if (bangJin[x][y] != 0) {
//				x = temp_x;
//				y = temp_y;
//				x++;
//				if (x >= N + 1) {
//					x = 1;
//				}
//
//				bangJin[x][y] = input_Num++;
//
//				x = x - 1;
//				if (x < 1) {
//					x = N;
//				}
//				temp_y = y;
//				y = y + 1;
//				if (y >= N + 1) {
//					y = 1;
//				}
//			}
//		}
//		for (int i = 0; i <= N; i++) {
//			System.out.println(Arrays.toString(bangJin[i]));
//		}

		boolean isRight = bangJin_check(bangJin, (N*N * N+N)/2);

		if (isRight) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

	private static boolean bangJin_check(int[][] bangJin, int num) {
		int sum_garo;
		int sum_sero;
		int sum_Lcross;
		int sum_Rcross;

		boolean flag = true;
		sum_garo = 0;
		sum_sero = 0;
		sum_Lcross = 0;
		sum_Rcross = 0;
		// 가로,세로
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum_garo += bangJin[i][j];
				sum_sero += bangJin[j][i];
			}
			if (sum_garo == num && sum_sero == num) {
				flag = true;
			} else {
				flag = false;
				return flag;
			}
			sum_garo = 0;
			sum_sero = 0;
		}
		// 왼쪽위부터 대각선
		for (int i = 1; i <= N; i++) {
			sum_Lcross += bangJin[i][i];
		}

		// 대각선
		int idx = N;
	    for(int i = 1; i <= N; i++) {
	        sum_Rcross += bangJin[i][idx];
	        idx--;
	    }
		if (sum_Lcross == num && sum_Rcross == num) {
			flag = true;
		} else {
			flag = false;
			return flag;
		}
		return flag;
	}
}