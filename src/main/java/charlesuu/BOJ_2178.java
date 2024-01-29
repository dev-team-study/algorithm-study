package charlesuu;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178 {
    
	public static int N;
	public static int M;
	private static int[][] a;
	private static int[][] dist;
	private static int[] dX = {-1, 1, 0, 0};
	private static int[] dY = {0, 0, -1, 1};

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		a = new int[N][M];
		dist = new int[N][M];

		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < M; j++) {
				a[i][j] = line.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}

		bfs(0, 0);

		System.out.println(dist[N - 1][M - 1]);
	}

	private static void bfs(int x, int y) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(x);
		q.add(y);
		dist[x][y] = 1;

		while (!q.isEmpty()) {
			x = q.poll();
			y = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = x + dX[i];
				int nY = y + dY[i];

				if (0 <= nX && nX < N && 0 <= nY && nY < M) {
					if (a[nX][nY] == 1 && dist[nX][nY] == -1) {
						q.add(nX);
						q.add(nY);
						dist[nX][nY] = dist[x][y] + 1;
					}
				}
			}
		}
	}
}
