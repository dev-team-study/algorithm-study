package tommy;

import java.util.Scanner;

public class BOJ_11052 {
    static int N;
    static int[] P; // 금액
    static int[] R; // max 금액(합)

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                R[i] = Math.max(R[i], R[i - j] + P[j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        P = new int[1001];
        R = new int[1001];
        for (int i = 1; i <= N; i++) {
            P[i] = sc.nextInt();
        }
        solution();

        System.out.println(R[N]);
    }
}
