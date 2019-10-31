import java.util.Scanner;

//n이 4가되면 종료
//증가하다가 어떤수의 제곱이면 아웃

public class swea_6782 {

	static final int MAX = 1000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long T = sc.nextLong();

		for (long tc = 1; tc <= T; tc++) {
			long count = 0;
			long start_num = sc.nextLong();

			long[] powSet = new long[MAX + 1];
			for (int i= 1; i <= MAX; i++) {
				powSet[i] = (long) Math.pow(i, 2);
			}

			// 현재위치 리턴
			long index = 0;
			// 이분탐색
			while (true) {
				index = binarySearch(powSet, start_num);
				while(true) {
					if (Math.pow(index, 2) == start_num) {
						start_num = index;
						index = binarySearch(powSet, start_num);
						count++;
					}
					else {
						break;
					}
				}
				if (start_num == 2) {
					break;
				} else if (start_num != 2) {
					start_num++;
					count++;
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}

	private static long binarySearch(long[] powSet, long target) {
		long first = 0;
		// long last = powSet.length;
		long last = MAX + 1;
		long mid = 0;

		while (first <= last) {
			mid = (first + last) / 2;
			if (target == powSet[(int) mid]) {
				return mid;
			} else {
				if (target < powSet[(int) mid])
					last = mid - 1;
				else
					first = mid + 1;
			}
		}
		return mid;
	}
}