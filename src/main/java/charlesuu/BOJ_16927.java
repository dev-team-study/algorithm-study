package charlesuu;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_16927 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		int[][] a = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int kCount = Math.min(N, M) / 2;
		ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
		for (int k = 0; k < kCount; k++) {
			ArrayList<Integer> group = new ArrayList<>();
			for (int j = k; j < M - k; j++) {
				group.add(a[k][j]);
			}
			for (int i = k + 1; i < N - 1 - k; i++) {
				group.add(a[i][M - 1 - k]);
			}
			for (int j = M - 1 - k; j > k; j--) {
				group.add(a[N - 1 - k][j]);
			}
			for (int i = N - k - 1; i > k; i--) {
				group.add(a[i][k]);
			}
			groups.add(group);
		}

		for (int k = 0; k < kCount; k++) {
			ArrayList<Integer> group = groups.get(k);
			int n = group.size();
			int index = R % n;

			for (int j = k; j < M - k; j++) {
				a[k][j] = group.get(index);
				index = (index + 1) % n;
			}
			for (int i = k + 1; i < N - 1 - k; i++) {
				a[i][M - 1 - k] = group.get(index);
				index = (index + 1) % n;
			}
			for (int j = M - 1 - k; j > k; j--) {
				a[N - 1 - k][j] = group.get(index);
				index = (index + 1) % n;
			}
			for (int i = N - k - 1; i > k; i--) {
				a[i][k] = group.get(index);
				index = (index + 1) % n;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(a[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
