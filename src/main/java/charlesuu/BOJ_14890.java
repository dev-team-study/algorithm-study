package charlesuu;

import java.util.Scanner;

public class BOJ_14890 {

	public static int N;
	public static int L;

	private static boolean go(int[] line) {
		boolean[] c = new boolean[N];

		for (int i = 1; i < N; i++) {
			if (line[i - 1] != line[i]) {
				int diff = Math.abs(line[i - 1] - line[i]);
				if (diff != 1) {
					return false;
				}

				//오르막길
				if (line[i - 1] < line[i]) {
					for (int j = 1; j <= L; j++) {
						if (i - j < 0) {
							return false;
						}

						if (line[i - 1] != line[i - j]) {
							return false;
						}

						if (c[i - j]) {
							return false;
						}
						c[i - j] = true;
					}
				} else {
					for (int j = 0; j < L; j++) {
						if (i + j >= N) {
							return false;
						}

						if (line[i] != line[i + j]) {
							return false;
						}

						if (c[i + j]) {
							return false;
						}
						c[i + j] = true;
					}
				}

			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();

		int[][] a = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			int[] line = new int[N];

			for (int j = 0; j < N; j++) {
				line[j] = a[i][j];
			}

			if (go(line)) {
				count++;
			}
		}

		for (int j = 0; j < N; j++) {
			int[] line = new int[N];
			for (int i = 0; i < N; i++) {
				line[i] = a[i][j];
			}

			if (go(line)) {
				count++;
			}
		}

		System.out.println(count);
	}

}