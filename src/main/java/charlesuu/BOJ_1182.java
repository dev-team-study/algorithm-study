package charlesuu;

import java.util.Scanner;

public class BOJ_1182 {

	public static int[] sS;
	public static int[] numsArr;
	public static int count = 0;
	public static int N;
	public static int S;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		sS = new int[N];
		numsArr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			numsArr[i] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			recursive(0, 1, N, i);
		}

		System.out.println(count);
	}

	public static void recursive(int index, int start, int N, int M) {
		if (index == M) {
			process(M);
			return;
		}
		for (int i = start; i <= N; i++) {
			sS[index] = i;
			recursive(index + 1, i + 1, N, M);
		}
	}

	private static void process(int M) {
		int sum = 0;
		for (int i = 0; i < M; i++) {
			int tmp = sS[i];
			sum += numsArr[tmp];
		}

		if (sum == S) {
			count++;
		}
	}
}
