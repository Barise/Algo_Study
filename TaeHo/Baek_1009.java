//분산처리
// 현재 계속 틀리는중..


//아이디어생각 못해서 참조함
//단순히 Math.pow(a,b)%10 하면 숫자가 너무 커서 무조건 오류!
//컨닝한 아이디어 
// (a*b)%c = (a%c)*(b%c)
// 기릿!
import java.util.Scanner;

public class Baek_1009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] a = new int[T];
		int[] b = new int[T];
		for (int tc = 0; tc < T; tc++) {
			a[tc] = sc.nextInt();
			b[tc] = sc.nextInt();
		}
		int w =0;
		//바로 적용!!
		for (int i = 0; i < T; i++) {
			w= (int) (Math.pow(a[i]%10, b[i] % 10) % 10);
			if(w==0) {
				System.out.println(10);
			}
			else {
				System.out.println(w);
			}
		}
	}
}
