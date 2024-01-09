package charlesuu;

import java.util.Scanner;

public class BOJ_11726 {

	public static int[] DP;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		DP = new int[n + 1];

		DP[1] = 1;
		DP[2] = 2;

		for (int i = 3; i <= n; i++) {
			DP[i] = (DP[i - 1] + DP[i - 2]) % 10007;
		}

		System.out.println(DP[n]);
	}
}