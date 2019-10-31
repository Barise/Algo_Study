//피보나치 함수

import java.util.Arrays;
import java.util.Scanner;

public class Baek_1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int[] dp = new int[n+1];
			int[] zero_Table = new int[n+1];
			int[] one_Table = new int[n+1];
			
			dp[0]=1;
			zero_Table[0]=1;
			if(n>0) {
				dp[1]=1;
				one_Table[1]=1;
			}
			
			for (int j = 2; j < dp.length; j++) {
				dp[j]=dp[j-1]+dp[j-2];
				zero_Table[j]=zero_Table[j-1]+zero_Table[j-2];
				one_Table[j]=one_Table[j-1]+one_Table[j-2];
			}
			
			System.out.println(zero_Table[n]+" " + one_Table[n]);
		}
		
	}
}