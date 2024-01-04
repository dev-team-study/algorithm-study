package tommy;

import java.util.Scanner;

public class BOJ_10819 {

    static int N;
    static int[] A;
    static int[] answer;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    /*
     * 시간 복잡도 : O(N!)
     * 공간 복잡도 : O(N)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        answer = new int[N];
        visited = new boolean[N];

        backTracking(0);
        System.out.println(max);
    }

    private static void backTracking(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(answer[i] - answer[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                answer[depth] = A[i];
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
