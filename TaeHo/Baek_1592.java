import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//영식이와 친구들
public class Baek_1592 {
	static int[] arr;
	static boolean[] isUse;
	static ArrayList<Integer> list;
	static int sum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		isUse = new boolean[N];
		int[] output_arr = new int[3];
		list = new ArrayList<>();
		sum = 0;
		int count = 0;
		String str1 = br.readLine();
		System.out.println();
		StringTokenizer st1 = new StringTokenizer(str1);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}

		dfs(N, 3, count,output_arr);
		System.out.println(list.toString());
	}

	private static void dfs(int n, int i, int count,int[] output_arr) {
		// TODO Auto-generated method stub
		if (count == i) {
			for (int j = 0; j < i; j++) {
				System.out.print(output_arr[j]+ " ");
			}
			System.out.println();
			list.add(sum);
			sum=0;
			return;
		}
		for (int j = 0; j < n; j++) {
			if (isUse[j] == false) {
				isUse[j] = true;
				sum += arr[j];
				output_arr[j]= arr[j];
				dfs(n, i, count + 1,output_arr);
				isUse[j] = false;
			}
		}
	}
}
