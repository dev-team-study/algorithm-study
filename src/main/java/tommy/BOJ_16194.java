package tommy;

import java.util.Scanner;

public class BOJ_16194 {

    static int N;

    static int[] P;
    static int[] R;

    /*
     * 시간 복잡도 : O(N^2)
     * 공간 복잡도 : O(N)
     */
    private static void solution() {
        for (int i = 1; i <= N; i++) {
            R[i] = P[i];
            for (int j = 1; j <= i; j++) {
                R[i] = Math.min(R[i], R[i - j] + P[j]);
            }
        }
        System.out.println(R[N]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        P = new int[N + 1];
        R = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = sc.nextInt();
        }
        solution();
    }
}
