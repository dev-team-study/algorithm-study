package tommy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {
    static int N, M, V;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        // initializing
        arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int V) {
        visited[V] = true;
        sb.append(V + " ");

        if (V == arr.length) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[V][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    private static void bfs(int V) {
        Queue<Integer> que = new LinkedList<>();

        que.add(V);
        visited[V] = true;
        sb.append(V + " ");

        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[temp][i] == 1 && visited[i] == false) {
                    que.add(i);
                    visited[i] = true;
                    sb.append(i + " ");
                }
            }
        }
    }
}
