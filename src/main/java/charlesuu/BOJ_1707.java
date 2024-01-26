package charlesuu;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1707 {

	public static ArrayList<Integer>[] a;
	public static int[] color;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		while (k-- > 0) {
			int v = sc.nextInt();
			int e = sc.nextInt();

			a = new ArrayList[v + 1];
			color = new int[v + 1];

			for (int i = 1; i <= v; i++) {
				a[i] = new ArrayList<>();
			}

			for (int i = 0; i < e; i++) {
				int f = sc.nextInt();
				int b = sc.nextInt();

				a[f].add(b);
				a[b].add(f);
			}

			boolean ok = true;
			for (int i = 1; i <= v; i++) {
				if (color[i] == 0) {
					if (!dfs(i, 1)) {
						ok = false;
					}
				}
			}

			if (ok) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean dfs(int x, int c) {
		color[x] = c;
		for (int y : a[x]) {
			if (color[y] == 0) {
				if (!dfs(y, 3 - c)) {
					return false;
				}
			} else if (color[y] == c) {
				return false;
			}
		}
		return true;
	}
}
