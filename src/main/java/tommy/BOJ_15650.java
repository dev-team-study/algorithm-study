package tommy;

import java.util.Scanner;

public class BOJ_15650 {
    private static int N;
    private static int M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    /*
     * 시간 복잡도 : O(N!) -> DFS
     * 공간 복잡도 : O(N) -> int[] 배열 생성
     */
    private void solution() {
        arr = new int[M];
        dfs(1, 0);
        System.out.println(sb);
    }

    private void dfs(int startNum, int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = startNum; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }


    public static void main(String[] args) {
        BOJ_15650 main = new BOJ_15650();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        main.solution();
    }
}
