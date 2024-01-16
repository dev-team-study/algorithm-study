package charlesuu;

import java.util.Scanner;

public class BOJ_15988 {

	public static long[] d = new long[1000001];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			System.out.println(recursive(n));
		}

	}

	private static long recursive(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}

		if (d[n] != 0) {
			return d[n];
		}

		d[n] = (recursive(n - 1) + recursive(n - 2) + recursive(n - 3)) % 1000000009;
		return d[n];
	}
}
