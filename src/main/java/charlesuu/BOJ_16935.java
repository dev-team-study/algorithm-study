package charlesuu;

import java.util.Scanner;

public class BOJ_16935 {
	
	public static int n;
	public static int m;
	public static int R;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		R = sc.nextInt();

		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		while (R-- > 0) {
			int op = sc.nextInt();

			switch (op) {
				case 1:
					a = operation1(a);
					break;
				case 2:
					a = operation2(a);
					break;
				case 3:
					a = operation3(a);
					break;
				case 4:
					a = operation4(a);
					break;
				case 5:
					a = operation5(a);
					break;
				case 6:
					a = operation6(a);
					break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				sb.append(a[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static int[][] operation1(int[][] a) {
		int N = a.length;
		int M = a[0].length;
		int[][] b = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				b[i][j] = a[N - 1 - i][j];
			}
		}
		return b;
	}

	private static int[][] operation2(int[][] a) {
		int N = a.length;
		int M = a[0].length;
		int[][] b = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				b[i][j] = a[i][M - 1 - j];
			}
		}
		return b;
	}

	private static int[][] operation3(int[][] a) {
		int N = a.length;
		int M = a[0].length;
		int[][] b = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				b[i][j] = a[N - 1 - j][i];
			}
		}
		return b;
	}

	private static int[][] operation4(int[][] a) {
		int N = a.length;
		int M = a[0].length;
		int[][] b = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				b[i][j] = a[j][M - 1 - i];
			}
		}
		return b;
	}

	private static int[][] operation5(int[][] a) {
		int N = a.length;
		int M = a[0].length;
		int[][] b = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				b[i][j + M / 2] = a[i][j];
				b[i + N / 2][j + M / 2] = a[i][j + M / 2];
				b[i + N / 2][j] = a[i + N / 2][j + M / 2];
				b[i][j] = a[i + N / 2][j];
			}
		}

		return b;
	}

	private static int[][] operation6(int[][] a) {
		int N = a.length;
		int M = a[0].length;
		int[][] b = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				b[i + N / 2][j] = a[i][j];
				b[i + N / 2][j + M / 2] = a[i + N / 2][j];
				b[i][j + M / 2] = a[i + N / 2][j + M / 2];
				b[i][j] = a[i][j + M / 2];
			}
		}

		return b;
	}
}
