package charlesuu;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576 {

	public static int N;
	public static int M;
	private static int[][] a;
	private static int[][] dist;
	private static int[] dX = {-1, 1, 0, 0};
	private static int[] dY = {0, 0, -1, 1};

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		a = new int[N][M];
		dist = new int[N][M];

		sc.nextLine();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] == 1) {
					q.add(i);
					q.add(j);
					dist[i][j] = 0;
				}
			}
		}

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = x + dX[i];
				int nY = y + dY[i];

				if (0 <= nX && nX < N && 0 <= nY && nY < M) {
					if (a[nX][nY] == 0 && dist[nX][nY] == -1) {
						q.add(nX);
						q.add(nY);
						dist[nX][nY] = dist[x][y] + 1;
					}
				}
			}
		}

		int answer = Integer.MIN_VALUE;
		boolean notComplete = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] == 0 && dist[i][j] == -1) {
					answer = -1;
					notComplete = true;
					break;
				}

				if (dist[i][j] > answer) {
					answer = dist[i][j];
				}
			}
			if (notComplete) {
				break;
			}
		}

		System.out.println(answer);
	}
}
