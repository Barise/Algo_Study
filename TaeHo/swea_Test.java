import java.util.Arrays;
import java.util.Scanner;

public class swea_Test {
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
			int result=123456789;
			
			for (int i = 1; i < N-1; i++) {
				temp=0;
				//무조건 첫째줄은 햐안색!
				temp+=check[0][1]+check[0][2];
				//무조건 막줄은 빨강색!
				temp+=check[N-1][0]+check[N-1][1];
				//파란줄 선택
					temp+=check[i][0];
					temp+=check[i][2];
				//하얀색줄
				for (int j = 1; j <i ; j++) {
					temp+=check[j][1]+check[j][2];
				}
				//빨간색줄
				for (int j = i+1; j < N-1; j++) {
					temp+=check[j][0]+check[j][1];
				}
				result=Math.min(temp, result);
				System.out.println(result + "i + : " + i);
				
			}
			System.out.println("#" + tc + " " + result);
			
		}
	}
}
