package charlesuu;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11724 {
	public static ArrayList<Integer>[] a;
	public static boolean[] c;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		a = (ArrayList<Integer>[])new ArrayList[n + 1];
		c = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (!c[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void dfs(int x) {
		if (c[x]) {
			return;
		}

		c[x] = true;
		for (int y : a[x]) {
			if (!c[y]) {
				dfs(y);
			}
		}
	}
}