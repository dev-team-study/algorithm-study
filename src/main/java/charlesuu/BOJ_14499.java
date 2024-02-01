package charlesuu;

import java.util.Scanner;

public class BOJ_14499 {

	public static int[] dX = {0, 0, -1, 1};
	public static int[] dY = {1, -1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int l = sc.nextInt();

		int[][] a = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int[] dice = new int[7];

		while (l-- > 0) {
			int k = sc.nextInt() - 1;

			int nX = x + dX[k];
			int nY = y + dY[k];

			if (!(0 <= nX && nX < N && 0 <= nY && nY < M)) {
				continue;
			}

			int tmp;
			switch (k) {
				case 0:
					tmp = dice[1];
					dice[1] = dice[4];
					dice[4] = dice[6];
					dice[6] = dice[3];
					dice[3] = tmp;
					break;
				case 1:
					tmp = dice[1];
					dice[1] = dice[3];
					dice[3] = dice[6];
					dice[6] = dice[4];
					dice[4] = tmp;
					break;
				case 2:
					tmp = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[6];
					dice[6] = dice[2];
					dice[2] = tmp;
					break;
				case 3:
					tmp = dice[1];
					dice[1] = dice[2];
					dice[2] = dice[6];
					dice[6] = dice[5];
					dice[5] = tmp;
					break;
			}
			x = nX;
			y = nY;

			if (a[x][y] == 0) {
				a[x][y] = dice[6];
			} else {
				dice[6] = a[x][y];
				a[x][y] = 0;
			}
			System.out.println(dice[1]);
		}
	}
}