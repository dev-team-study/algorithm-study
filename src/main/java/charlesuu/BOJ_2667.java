package charlesuu;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_2667 {
	public static int n;
	public static int[][] a;
	public static int[][] d;

	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		a = new int[n][n];
		d = new int[n][n];

		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < n; j++) {
				a[i][j] = line.charAt(j) - '0';
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1 && d[i][j] == 0) {
					bfs(i, j, ++cnt);
				}
			}
		}

		int[] answer = new int[cnt];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (d[i][j] != 0) {
					answer[d[i][j] - 1]++;
				}
			}
		}
		Arrays.sort(answer);

		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void bfs(int x, int y, int cnt) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(x, y));
		d[x][y] = cnt;

		while (!q.isEmpty()) {
			Pair polled = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = polled.x + dx[i];
				int ny = polled.y + dy[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (a[nx][ny] == 1 && d[nx][ny] == 0) {
						q.add(new Pair(nx, ny));
						d[nx][ny] = cnt;
					}
				}
			}
		}
	}
}
