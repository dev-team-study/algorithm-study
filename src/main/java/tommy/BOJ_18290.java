package tommy;

import java.util.Scanner;

public class BOJ_18290 {
    static int N, M, K;
    static int[][] arr;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    private void solution() {
        dfs(0, 0, 0, 0);
        System.out.println(max);
    }
    /*
     * 시간 복잡도 : O (N * M)!
     * 공간 복잡도 : O(N * M) -> arr, visited
     */
    private void dfs(int depth, int row, int col, int sum) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        if (depth == K) {
            max = Math.max(max, sum);
            return;
        }

        boolean isAdj;

        for (int i = row; i < N; i++) {
            for (int j = (row == i ? col : 0); j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }

                isAdj = false;
                for (int dir = 0; dir < 4; dir++) {
                    int ni = i + dx[dir];
                    int nj = j + dy[dir];
                    if ((ni >= 0 && ni < N && nj >= 0 && nj < M) && (visited[ni][nj])) {
                        isAdj = true;
                        break;
                    }
                }

                if (!isAdj) {
                    visited[i][j] = true;
                    dfs(depth + 1, i, j, sum + arr[i][j]);
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        BOJ_18290 main = new BOJ_18290();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        main.solution();
    }
}
