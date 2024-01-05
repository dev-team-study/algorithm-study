package charlesuu;

import java.util.Scanner;

public class BOJ_6063 {

    public static int[] selectSpace = new int[13];
    public static int[] s = new int[13];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            for (int i = 1; i <= N; i++) {
                s[i] = sc.nextInt();
            }
            recursive(0, 1, N);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recursive(int ssIndex, int presentNumber, int n) {
        if (ssIndex == 6) {
            print(6);
            return;
        }
        for (int i = presentNumber; i <= n; i++) {
            selectSpace[ssIndex] = i;
            recursive(ssIndex + 1, i + 1, n);
        }
    }

    private static void print(int n) {
        for (int i = 0; i < n; i++) {
            sb.append(s[selectSpace[i]]).append(" ");
        }
        sb.append("\n");
    }
}
