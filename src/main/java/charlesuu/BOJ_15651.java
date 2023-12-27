package charlesuu;

import java.util.Scanner;
/*
 시간 복잡도 : O(N * N!) < T < O(N^2 * N!)
 공간 복잡도 : O(N)
 */

public class BOJ_15651 {
    public static int[] selectSpace = new int[10];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        recursive(0, N, M);
        System.out.println(sb);
    }

    private static void recursive(int ssIndex, int N, int M) {
        if (ssIndex == M) {
            print(M);
            return;
        }//출력했으면 함수가 끝나야 함.
        for (int i = 1; i <= N; i++) {
            selectSpace[ssIndex] = i;
            recursive(ssIndex + 1, N, M);
        }

    }

    private static void print(int m) {
        for (int i = 0; i < m; i++) {
            sb.append(selectSpace[i]);
            if (i != m - 1) sb.append(" ");
        }
        sb.append("\n");
    }

}
