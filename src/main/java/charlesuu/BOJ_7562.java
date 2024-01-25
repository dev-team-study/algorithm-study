package charlesuu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562 {
	
	public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			int n = sc.nextInt();
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();

			int[][] d = new int[n][n];

			for (int j = 0; j < n; j++) {
				Arrays.fill(d[j], -1);
			}

			Queue<Integer> q = new LinkedList<>();
			q.add(sx);
			q.add(sy);
			d[sx][sy] = 0;

			while (!q.isEmpty()) {
				int x = q.remove();
				int y = q.remove();
				for (int k = 0; k < 8; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if (0 <= nx && nx < n && 0 <= ny && ny < n) {
						if (d[nx][ny] == -1) {
							d[nx][ny] = d[x][y] + 1;
							q.add(nx);
							q.add(ny);
						}
					}
				}
			}

			System.out.println(d[ex][ey]);
		}
	}
}
