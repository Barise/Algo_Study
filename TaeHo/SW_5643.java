import java.util.*;
import java.io.*;
//키 순서

//방향에 따라서 입력받고
//순방향 역방향 나눠서
//dfs돌리기
public class SW_5643 {
	static int[][] arr;
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T =sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][N];
			
			for (int i = 0; i < M; i++) {
				arr[sc.nextInt()-1][sc.nextInt()-1]=1;
			}
//			for (int i = N-1; i >= 0; i--) {
//				for (int j = i; j < N; j++) {
//					
//				}
//			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]==1) {
						
					}
					
				}
			}
			
		}
		
	}
}