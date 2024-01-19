package tommy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724 {
    static int N, M;
    static int[][] arr;
    static boolean[] visited;
    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N^2)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        // Initializing
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int tmp = que.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[tmp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }
    }
}
