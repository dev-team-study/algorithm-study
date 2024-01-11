package charlesuu;

/*
시간복잡도: O(N)
공간복잡도: O(1)
*/

import java.util.Scanner;

public class BOJ_1463 {
	public static int[] d = new int[10000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d[1] = 0;

		System.out.println(recursive(n));
	}

	private static int recursive(int n) {
		if (n == 1) {
			return 0;
		}

		if (d[n] != 0) {
			return d[n];
		}

		d[n] = recursive(n - 1) + 1;

		if (n % 3 == 0) {
			int tmp = recursive(n / 3) + 1;
			if (d[n] > tmp) {
				d[n] = tmp;
			}
		}

		if (n % 2 == 0) {
			int tmp = recursive(n / 2) + 1;
			if (d[n] > tmp) {
				d[n] = tmp;
			}
		}

		return d[n];
	}
}
