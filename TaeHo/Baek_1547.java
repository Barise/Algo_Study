//°ø

import java.util.Scanner;

public class Baek_1547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int Ball = 1;
		
		for (int i = 0; i < M; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			if(X == Ball) {
				Ball = Y;
			}else if(Y == Ball) {
				Ball = X;
			}
		}
		System.out.println(Ball);
	}

}
