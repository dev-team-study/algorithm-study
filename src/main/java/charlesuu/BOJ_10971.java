package charlesuu;

import java.util.Scanner;

public class BOJ_10971 {

    static int n;
    static int[][] arr;
    static boolean visit[];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            visit[i] = true;
            dfs(i, i, 0, 0);
            visit[i] = false;
        }

        System.out.println(result);
    }

    public static void dfs(int start, int now, int sum, int cnt) {
        if (cnt == n - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                if (sum < result) {
                    result = sum;
                }
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i] == false && arr[now][i] != 0) {
                visit[i] = true;
                dfs(start, i, sum + arr[now][i], cnt + 1);
                visit[i] = false;
            }
        }
    }
}
