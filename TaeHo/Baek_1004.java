import java.io.*;
import java.util.*;

public class Baek_1004 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int start_X, start_Y;
			int end_X, end_Y;
			StringTokenizer st = new StringTokenizer(br.readLine());
			start_X = Integer.parseInt(st.nextToken());
			start_Y = Integer.parseInt(st.nextToken());
			end_X = Integer.parseInt(st.nextToken());
			end_Y = Integer.parseInt(st.nextToken());
			
			int input_num = Integer.parseInt(st.nextToken());
			int circle_X,circle_Y,circle_r;
			int count=0;
			for (int i = 0; i < input_num; i++) {
				st = new StringTokenizer(br.readLine());
				circle_X = Integer.parseInt(st.nextToken());
				circle_Y = Integer.parseInt(st.nextToken());
				circle_r = Integer.parseInt(st.nextToken());
				//들어온 원 안에 있으면 count++ 
				//
				if((circle_X-circle_r)<start_X && (circle_X+circle_r) > start_X && (circle_Y-circle_r) <start_X && (circle_Y+circle_r) > start_Y) {
					count++;
				}
			}
			
		}
	}
}
