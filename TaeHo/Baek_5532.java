import java.util.Scanner;

//¹æÇÐ¼÷Á¦

public class Baek_5532 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		int temp_KOR = (A+(C-1))/C;
		int temp_Math= (B+(D-1))/D;
		
		int result = L-Math.max(temp_Math, temp_KOR);
		if(result<0) result = 0;
		System.out.println(result);
		
	}
}
