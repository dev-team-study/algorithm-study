package tommy;

import java.util.Scanner;

public class BOJ_15651 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    /*
     * 시간 복잡도 : O(N!)
     * 공간 복잡도 : O(M) -> arr 배열 생성
     */
    private void solution() {
        arr = new int[M];
        dfs(0);
        System.out.println(sb);
    }

    private void dfs(int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) {
        BOJ_15651 main = new BOJ_15651();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        main.solution();
    }
}
