import java.util.Arrays;
import java.util.Scanner;

public class swea_4050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N  = sc.nextInt();
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i]=sc.nextInt();
			}
			int result=0;
			Arrays.sort(arr);
			if(N%3==0) {
				for (int i = 0; i < N; i++) {
					if(i%3==0) {
					}else{
						result+=arr[i];
					}
				}
			}
			
			else if(N%3==1) {
				result+=arr[0];
				for (int i = 1; i < N; i++) {
					if(i%3==1) {
						continue;	
					}else{
						result+=arr[i];
					}
				}
			}
			
			else if(N%3==2) {
				result+=arr[0];
				result+=arr[1];
				for (int i = 2; i < N; i++) {
					if(i%3==2) {
						continue;
					}else{
						result+=arr[i];
					}
				}
			}
		
		System.out.println("#" + tc + " " + result);	
		}
	}
}
