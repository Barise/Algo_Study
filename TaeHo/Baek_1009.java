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
		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println((int) (Math.pow(a, b % 10) % 10));	
		}
	}
}


