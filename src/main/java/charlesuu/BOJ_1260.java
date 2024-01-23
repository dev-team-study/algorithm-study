package charlesuu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {

	public static ArrayList<Integer>[] a;
	public static boolean[] c;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();

		a = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(a[i]);
		}

		c = new boolean[n + 1];
		dfs(start);
		sb.append("\n");

		c = new boolean[n + 1];
		bfs(start);
		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();

		q.add(start);
		c[start] = true;
		sb.append(start).append(" ");
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int y : a[x]) {
				if (!c[y]) {
					q.add(y);
					c[y] = true;
					sb.append(y).append(" ");
				}
			}
		}
	}

	private static void dfs(int x) {
		if (c[x])
			return;

		c[x] = true;
		sb.append(x).append(" ");

		for (int i = 0; i < a[x].size(); i++) {
			int y = a[x].get(i);
			if (c[y] == false) {
				dfs(y);
			}
		}
	}
}
