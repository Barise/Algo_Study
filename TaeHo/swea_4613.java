import java.util.Arrays;
import java.util.Scanner;

public class swea_4613 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N =sc.nextInt();
			int M = sc.nextInt();
			char[][] arr = new char[N][M];
			
			//순서는 WBR
			int[][] check = new int[N][3];
			String str;
			//check세팅
			for (int i = 0; i < N; i++) {
				str = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j]=str.charAt(j);
					if(arr[i][j]=='W') {
						check[i][0]++;
					}else if(arr[i][j]=='B') {
						check[i][1]++;
					}else{
						check[i][2]++;
					}
				}
			}
//			
//			for (int i = 0; i < check.length; i++) {
//				System.out.println(Arrays.toString(check[i]));
//			}
			int temp=0;
			int result=N*M;
			
			for (int i = 1; i < N-1; i++) {
				temp=0;
				//무조건 첫째줄은 햐안색!
				temp+=check[0][1]+check[0][2];
				//무조건 막줄은 빨강색!
				temp+=check[N-1][0]+check[N-1][1];
				//하얀색줄
				for (int j = 1; j <i ; j++) {
					temp+=check[j][1]+check[j][2];
				}
				int temp_t =temp;
				
				//파란줄 선택
				//지금 은 한줄
				for (int j = i; j < N-1; j++) {
					temp=temp_t;
					temp+=check[i][0];
					temp+=check[i][2];
					temp_t =temp;
					//빨간색줄
					for (int K = j+1; K < N-1; K++) {
						temp+=check[K][0]+check[K][1];
					}
					result=Math.min(temp, result);
				}
			}
			System.out.println("#" + tc + " " + result);
			
		}
	}
}
