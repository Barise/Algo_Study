import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class sw_combination {
	static int P = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N =sc.nextInt();
			int R = sc.nextInt();
			
			int[] modArr = new int[N+1];
			//1!은 1임
			modArr[0]=1;
			modArr[1]=1;
			for (int j = 1; j <= N; j++) {
				modArr[j]=modArr[j-1]*j%P;
			}
			System.out.println(Arrays.toString(modArr));
			
			long result = modArr[N] * power( modArr[N-R] * modArr[R] % P , P-2) %P;
			
			
			System.out.println("#"+i+" " + result);
		}
		
	}

	private static long power(int base, int ex) {
		
		if(ex==1) {
			return base;
		}
		long result = power(base,ex/2);
		if(ex%2==0) {
			return result*result%P ;
		}
		else {
			return result*result%P*base%P;
		}
	}

}
