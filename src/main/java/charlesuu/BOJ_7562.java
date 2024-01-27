package charlesuu;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562 {

	public static int l;
	private static int[][] dist;
	private static int[] dX = {-2, -2, -1, 1, 2, 2, 1, -1};
	private static int[] dY = {-1, 1, 2, 2, 1, -1, -2, -2};

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		while (T-- > 0) {
			l = sc.nextInt();

			dist = new int[l][l];
			for (int i = 0; i < l; i++) {
				Arrays.fill(dist[i], -1);
			}

			int x = sc.nextInt();
			int y = sc.nextInt();

			Queue<Integer> q = new ArrayDeque<>();
			q.add(x);
			q.add(y);
			dist[x][y] = 0;

			while (!q.isEmpty()) {
				x = q.poll();
				y = q.poll();
				for (int i = 0; i < 8; i++) {
					int nX = x + dX[i];
					int nY = y + dY[i];

					if (0 <= nX && nX < l && 0 <= nY && nY < l) {
						if (dist[nX][nY] == -1) {
							q.add(nX);
							q.add(nY);

							dist[nX][nY] = dist[x][y] + 1;
						}
					}
				}
			}
			sb.append(dist[sc.nextInt()][sc.nextInt()]).append("\n");
		}
		System.out.println(sb);
	}
}
