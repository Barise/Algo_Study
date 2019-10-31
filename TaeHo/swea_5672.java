import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//올해의 조련사

public class swea_5672 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
//			Queue<Character> q1 = new LinkedList<>();
//			Queue<Character> q2 = new LinkedList<>();
			String str = sc.next();
			for (int i = 0; i < N - 1; i++) {
				str += sc.next();
			}
			int idx = str.length() - 1;
			String result_str = "";
			for (int i = 0; i < str.length(); i++) {
				System.out.println("i : " + i);
				System.out.println("idx : " + idx);
				
				
				
				if (str.charAt(i) < str.charAt(idx)) {
					result_str += str.charAt(i);
					System.out.println("result1 : " + result_str );
				} else if (str.charAt(i) == str.charAt(idx)) {
					int temp_I = i;
					int temp_idx = idx;
					while (temp_I<temp_idx) {
						temp_I++;
						temp_idx--;
						System.out.println("ed" + temp_I);
						System.out.println("da" + temp_idx);
						
						if (temp_I > 0 && temp_idx > 0 && str.charAt(temp_I) < str.charAt(temp_idx)) {
							for (int j = i; j < temp_I; j++) {
//								result_str 	= str.charAt(j);
							}
							System.out.println("result3 : " + result_str);
							i=temp_I;
							break;
							
						} else if (temp_I > 0 && temp_idx > 0 && str.charAt(temp_I) > str.charAt(temp_idx)) {
							for (int j = idx; j > temp_idx; j--) {
								result_str += str.charAt(j);
							}
							System.out.println("result4 : " + result_str);
							idx=temp_idx;
							break;
						}
					}
				} else if (str.charAt(i) > str.charAt(idx)) {
					result_str += str.charAt(idx);
					System.out.println("result2 : " + result_str );
					idx--;
					i--;
				}
				
				if(i==idx) {
					break;
				}
			}

			System.out.println("#" + tc + " " + result_str);
		}
	}
}