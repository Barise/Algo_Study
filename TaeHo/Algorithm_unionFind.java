//상호배타집합 - 교집합이 없는 집합
//집합을 구분하기 위해서 집합을 구분하기 위한 식별자가 필요

//makeSet 해당원소를 집합의 식별자로 하는 새로운 집합을 생성
//findSet 해당원소가 속한 집합의 대표자를 찾는 연산

//makeSet : 자기자신을 부모로 설정
//find : 자기자신이 부모인 노드가 나올때까지 부모를 재귀호출
//union : 두 대표자간에 한쪽을 부모로 설정
import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_unionFind {
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		int N = sc.nextInt();// 노드의 갯수
		int M = sc.nextInt();// 두 원소가 같은 집합임을 표현하는 입력의 갯수
		parent = new int[N + 1];
		rank = new int[N + 1];

		// makeSet연산을 수행 하시오
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		// M개의 연산에 대해서 유니온 하고,
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b);
		}
		int cnt = 0;
		// 모두 유니온 한 후에 집합의 갯수를 출력하시오
		for (int i = 1; i <= N; i++) {
			if (parent[i] == i) {
				cnt++;
			}
		}
		System.out.println(Arrays.toString(parent));
		
	}

	// x원소의 대표자를 찾아서 리턴
	static int find(int x) {
		// 자신의 부모가 자신이면 루트노드이므로, 대표자. 그러니까 자신을 리턴
		if (parent[x] == x) {
			return x;
		}
		// 아니라면, 계속해서 부모를 찾아나감
		else {
			// 바로 부모를 찾아나감
			return parent[x] = find(parent[x]);
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (rank[a] > rank[b]) {
			parent[b] = a;
		} else {
			parent[a] = b;
			if (rank[a] == rank[b]) {
				rank[b]++;
			}
		}
	}

	static final String src = "7 8\n" + "1 2\n" + "1 3\n" + "2 4\n" + "2 5\n" + "4 6\n" + "5 6\n" + "6 7\n" + "3 7\n";
}