//���� �� ���� ��..?

import java.util.Arrays;
import java.util.Scanner;

public class Baek_5597 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[31];
		int[] output = new int[2];
		for (int i = 1; i <= 28; i++) {
			arr[sc.nextInt()]++;
		}
		int idx=0;
		for (int i = 1; i <=30 ; i++) {
			if(arr[i]==0) {
				output[idx]=i;
				idx++;
			}
		}
		Arrays.sort(output);
		System.out.println(output[0]);
		System.out.println(output[1]);
	}
}
