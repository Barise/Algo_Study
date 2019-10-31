//보물상자 비밀번호

import java.util.Arrays;
import java.util.Scanner;

public class swea_5658{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int length = sc.nextInt();
			int big_Num = sc.nextInt();
			int square_Num = length/4;
			char[] arr = new char[length+1];
			String str = sc.next();
			
			arr= str.toCharArray();
			
			for (int i = 0; i < square_Num; i++) {
				for (int j = arr.length-1; j > 0; j--) {
					arr[j]=arr[j+1];
				}
				arr[0]=arr[arr.length-1];
			}
			System.out.println(Arrays.toString(arr));
			
			
			
			
		}
		
	}
}