import java.io.*;
import java.util.*;
public class SW_7701 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Set<String> set = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                set.add(br.readLine());
            }
            ArrayList<String> list = new ArrayList<>(set);
            list.sort(new Comparator<String>() {
				@Override
				 public int compare(String o1, String o2) {
                    if (o1.length() > o2.length())
                        return 1;
                    else if (o1.length() == o2.length())
                        return o1.compareTo(o2);
                    return -1;
                }
            });
            StringBuilder sb = new StringBuilder();
            sb.append("#"+t+"\n");
            for (int i = 0; i < list.size(); i++)
                sb.append(list.get(i)+"\n");
            bw.write(sb.toString());
            bw.flush();
        }
        bw.close();
    }
}
