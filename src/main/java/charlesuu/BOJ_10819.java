package charlesuu;

import java.util.Scanner;
/*
 시간 복잡도 :
 공간 복잡도 :
 */

public class BOJ_10819 {
    public static int n;
    public static int[] arr;
    public static int[] ans;
    public static boolean[] visit;
    public static int result;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        arr = new int[n];
        ans = new int[n];

        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(ans[i] - ans[i + 1]);
            }
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                ans[depth] = arr[i];
                visit[i] = true;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
