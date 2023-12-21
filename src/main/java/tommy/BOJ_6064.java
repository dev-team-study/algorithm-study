package tommy;

import java.util.Scanner;

public class BOJ_6064 {
    /*
     * x < M => x' = x + 1  |  x' = 1
     * y < N => y' = y + 1  |  y' = 1
     */
    private void solution(int[] M, int[] N, int[] x, int[] y) {
        for (int i = 0; i < M.length; i++) {
            boolean checker = false;
            for (int j = x[i]; j < M[i] * N[i]; j += M[i]) {
                if (j % N[i] == y[i]) {
                    System.out.println(j + 1);
                    checker = true;
                    break;
                }
            }
            if (!checker) {
                System.out.println(-1);
            }
        }

    }

    public static void main(String[] args) {
        BOJ_6064 BOJ6064 = new BOJ_6064();
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int[] M = new int[rows];
        int[] N = new int[rows];
        int[] x = new int[rows];
        int[] y = new int[rows];
        for (int i = 0; i < rows; i++) {
            M[i] = sc.nextInt();
            N[i] = sc.nextInt();
            x[i] = sc.nextInt() - 1;
            y[i] = sc.nextInt() - 1;
        }

        BOJ6064.solution(M, N, x, y);
    }
}
