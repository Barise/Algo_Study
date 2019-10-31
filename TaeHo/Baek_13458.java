import java.util.Scanner;

public class Baek_13458 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int room_Num = sc.nextInt();
		int[] room = new int[room_Num];
		for (int i = 0; i < room_Num; i++) {
			room[i] = sc.nextInt();
		}
		int Main_Super = sc.nextInt();
		int Sub_Super = sc.nextInt();
		long count = 0;
		for (int i = 0; i < room_Num; i++) {
			room[i] -= Main_Super;
			if(room[i]<=0)	room[i]=0;
			if (room[i] % Sub_Super == 0) {
				count += room[i] / Sub_Super;
			} else {
				count += room[i] / Sub_Super + 1;
			}
		}
		long result = room_Num + count;

		System.out.println(result);
	}

}
