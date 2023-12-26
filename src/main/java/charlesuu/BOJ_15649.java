package charlesuu;

import java.util.Scanner;
/*
 시간 복잡도 : O(N * N!) < T < O(N^2 * N!)
 공간 복잡도 : O(N)
 */

public class BOJ_15649 {
    public static int[] selectSpace = new int[10];
    public static boolean[] selected = new boolean[10];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        permutation(0, N, M);
    }

    private static void permutation(int level, int n, int m) {
        if (level == m) {
            print(m);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (selected[i])
                continue;

            selected[i] = true;
            selectSpace[level] = i;
            permutation(level + 1, n, m);
            selected[i] = false;
        }
    }

    private static void print(int m) {
        for (int i = 0; i < m; i++) {
            System.out.print(selectSpace[i] + " ");
        }
        System.out.println();
    }

}
