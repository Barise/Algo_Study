
//스타트와 링크

import java.io.*;
import java.util.*;

public class Baek_14889 {
	static boolean[] isUse;
	static boolean[] isUse2;
	static int[] map;
	static int[][] arr;
	static ArrayList<Integer> list= new ArrayList<>();
	static int sum=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		arr = new int[N][N];
		isUse = new boolean[N];
		isUse2 = new boolean[N];
		int[] sel_arr = new int[N];
		map = new int[N];
		for (int i = 0; i < N; i++) {
			map[i] = i+1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int M = N / 2;
		comb(N, M, 0,sel_arr);
		
//		Collections.sort(list);
		int max=987654321;
		for (int i = 0; i < list.size()-1; i++) {
			max = Math.min(max, list.get(i+1)-list.get(i));
		}
		
		System.out.println(list.toString());
		System.out.println(max);
	}
//두개 뽑고
	private static void comb(int n, int m, int cnt,int sel_arr[]) {
		if (cnt == m) {
			int[] result_arr = new int[n];
			comb2(m, 0, sel_arr,result_arr,2);
			list.add(sum);
			sum=0;
			
			for (int i = 0; i < m; i++) {
				System.out.print(sel_arr[i] +" ");
			}
			System.out.println();
		}
		for (int i = 0; i < n; i++) {
			if (isUse[i] == false) {
				if (cnt != 0) {
					if (sel_arr[cnt - 1] > map[i]) {
						continue;
					}
				}
				isUse[i] = true;
				sel_arr[cnt] = map[i];
				comb(n, m, cnt + 1,sel_arr);
				isUse[i] = false;
			}
		}
	}
	
	private static void comb2(int m, int cnt,int sel_arr[],int result_arr[],int K) {
		if (cnt == K) {
			sum += arr[result_arr[0]-1][result_arr[1]-1];
			
		}
		for (int i = 0; i < m; i++) {
			if (isUse2[i] == false) {
				isUse2[i] = true;
				
				result_arr[cnt] = sel_arr[i];
				comb2(m, cnt + 1,sel_arr,result_arr,K);
				isUse2[i] = false;
			}
		}
	}
}