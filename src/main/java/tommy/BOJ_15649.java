package tommy;

import java.util.Scanner;

public class BOJ_15649 {
    private static int N;
    private static int M;
    private int[] arr;
    private boolean[] visit;

    /*
     * Back Tracking
     * 시간 복잡도 : O(N!)
     * 공간 복잡도 : O(N)    -> int[], boolean[] 생성
     */
    private void solution() {
        arr = new int[M];
        visit = new boolean[N];
        dfs(0);
    }

    private void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;    // 방문 기록
                arr[depth] = i + 1;
                dfs(depth + 1);

                visit[i] = false;   // 방문 초기화
            }
        }
    }

    public static void main(String[] args) {
        BOJ_15649 prob = new BOJ_15649();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        prob.solution();
    }
}
