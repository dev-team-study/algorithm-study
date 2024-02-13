package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16967 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int H, W, X, Y;

    public static void main(String[] args) throws IOException {

        String[] line = bufferedReader.readLine().split(" ");

        H = Integer.parseInt(line[0]);
        W = Integer.parseInt(line[1]);
        X = Integer.parseInt(line[2]);
        Y = Integer.parseInt(line[3]);

        int[][] arrA = new int[H][W];
        int[][] arrB = new int[H + X][W + Y];

        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        noOverlap(arrA, arrB);
        overlap(arrA, arrB);

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(arrA[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void noOverlap(final int[][] arrA, final int[][] arrB) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < W; j++) {
                arrA[i][j] = arrB[i][j];
            }
        }

        for (int i = X; i < H; i++) {
            for (int j = 0; j < Y; j++) {
                arrA[i][j] = arrB[i][j];
            }
        }
    }

    private static void overlap(final int[][] arrA, final int[][] arrB) {
        for (int i = X; i < H; i++) {
            for (int j = Y; j < W; j++) {
                arrA[i][j] = arrB[i][j] - arrA[i - X][j - Y];
            }
        }
    }
}
