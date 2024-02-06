package tommy;

import java.util.Scanner;

public class BOJ_15662 {
    static int T;   // 톱니 바퀴의 수
    static int[][] chain;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        // Initializing Chain
        chain = new int[T][8];  // 날은 8개
        for (int i = 0; i < T; i++) {
            String tmp = sc.next();
            for (int j = 0; j < tmp.length(); j++) {
                chain[i][j] = tmp.charAt(j) - '0';
            }
        }

        int K = sc.nextInt();
        for (int k = 0; k < K; k++) {
            int chainNum = sc.nextInt() - 1;
            int direction = sc.nextInt();
            visited = new boolean[T];
            compute(chainNum, direction);
        }

        int cnt = 0;
        for (int i = 0; i < T; i++) {
            if (chain[i][0] == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void compute(int chainNum, int direction) {
        visited[chainNum] = true;
        rotate(chainNum, direction);

        if (chainNum - 1 >= 0 && !visited[chainNum - 1] && chain[chainNum - 1][2] != chain[chainNum][6 + direction]) {
            compute(chainNum - 1, direction * -1);
        }
        if (chainNum + 1 < T && !visited[chainNum + 1] && chain[chainNum + 1][6] != chain[chainNum][2 + direction]) {
            compute(chainNum + 1, direction * -1);
        }
    }

    private static void rotate(int chainNum, int direction) {
        if (direction == 1) {
            int tmp = chain[chainNum][7];
            for (int i = 7; i >= 1; i--) {
                chain[chainNum][i] = chain[chainNum][i - 1];
            }
            chain[chainNum][0] = tmp;
        } else {
            int tmp = chain[chainNum][0];
            for (int i = 0; i < 7; i++) {
                chain[chainNum][i] = chain[chainNum][i + 1];
            }
            chain[chainNum][7] = tmp;
        }
    }

}
