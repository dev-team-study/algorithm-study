package tommy;

import java.util.Scanner;

public class BOJ_10973 {
    static int N;
    static int[] input;

    public static void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static boolean solution() {
        int i = N - 1;
        while (i > 0 && input[i - 1] <= input[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = N - 1;
        while (input[j] >= input[i - 1]) {
            j--;
        }

        swap(i - 1, j);

        j = N - 1;
        while (i < j) {
            swap(i, j);
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        if (solution()) {
            for (int i = 0; i < N; i++) {
                System.out.print(input[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }
}
