import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw_7206 {
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int N = Integer.parseInt(str);
			result = 0;

			recursive(N, 0);

			System.out.println("#" + tc + " " + result);
		}

	}

	private static void recursive(int N, int count) {
		if (N < 10) {
			result = Math.max(count, result);
			return;
		}
		if (N >= 10) {
			recursive((N / 10) * (N % 10), count + 1);
		}
		if (N >= 100) {
			recursive((N / 100) * (N % 100), count + 1); //백
			recursive((N / 100) * (N % 100 / 10) * (N % 10), count + 1); //백십
		}
		if (N >= 1000) {
			recursive((N / 1000) * (N % 1000), count + 1); // 천
			recursive((N / 1000) * (N % 1000 / 100) * (N % 100), count + 1); //천백
			recursive((N / 1000) * (N % 1000 / 10) * (N % 10), count + 1); //천십
			recursive((N / 1000) * (N % 1000 / 100) * (N % 100 / 10) * (N % 10), count + 1); // 천백십
		}
		if (N >= 10000) {
			recursive((N / 10000) * (N % 10000), count + 1);// 만
			recursive((N / 10000) * (N % 10), count + 1);// 만십
			recursive((N / 10000) * (N % 100), count + 1); // 만백
			recursive((N / 10000) * (N % 1000), count + 1); // 만천

			recursive((N / 10000) * (N % 10000 / 1000) * (N % 1000 / 100) * (N % 100), count + 1); // 만천백
			recursive((N / 10000) * (N % 10000 / 1000) * (N % 1000 / 10) * (N % 10), count + 1);// 만천십
			recursive((N / 10000) * (N % 10000 / 100) * (N % 100 / 10) * (N % 10), count + 1); // 만백십
			recursive((N / 10000) * (N % 10000 / 1000) * (N % 1000 / 100) * (N % 100 / 10) * (N % 10), count + 1);// 만천백십

		}
	}
}