//�л�ó��
// ���� ��� Ʋ������..


//���̵����� ���ؼ� ������
//�ܼ��� Math.pow(a,b)%10 �ϸ� ���ڰ� �ʹ� Ŀ�� ������ ����!
//������ ���̵�� 
// (a*b)%c = (a%c)*(b%c)
// �⸴!
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
		//�ٷ� ����!!
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
