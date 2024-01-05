package tommy;

import java.util.Scanner;

public class BOJ_10971 {

    static int N;
    static int[][] W;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;


    private static void solution(int depth, int start, int now, int cost) {
        if (depth == N - 1) {
            if (W[now][start] != 0) {
                cost += W[now][start];
                minCost = Math.min(minCost, cost);
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && W[now][i] != 0) {
                visited[i] = true;
                solution(depth + 1, start, i, cost + W[now][i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                W[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            solution(0, i, i, 0);
            visited[i] = false;
        }

        System.out.println(minCost);
    }
}
