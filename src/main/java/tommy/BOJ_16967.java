package tommy;

import java.util.Scanner;

public class BOJ_16967 {
    static int H, W, X, Y;

    static int[][] A;
    static int[][] B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();

        A = new int[H][W];
        B = new int[H + X][W + Y];
        for (int i = 0; i < H + X; i++) {
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = B[i][j];
            }
        }

        for (int i = X; i < H; i++) {
            for (int j = 0; j < Y; j++) {
                A[i][j] = B[i][j];
            }
        }

        for (int i = X; i < H; i++) {
            for (int j = Y; j < W; j++) {
                A[i][j] = B[i][j] - A[i - X][j - Y];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
