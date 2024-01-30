package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1261 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] mx = {0, 0, -1, 1};
    private static int[] my = {-1, 1, 0, 0};
    private static int M, N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        visited = new boolean[N + 1][M + 1];
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = sc.nextLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }
        bfs(1, 1);
    }

    private static void bfs(final int x, final int y) {
        Queue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            if (node.x == N && node.y == M) {
                System.out.println(node.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int dx = mx[i] + node.x;
                int dy = my[i] + node.y;

                if (dx < 1 || dy < 1 || dx > N || dy > M) {
                    continue;
                }

                if (!visited[dx][dy] && map[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    priorityQueue.offer(new Node(dx, dy, node.count + 1));
                }

                if (!visited[dx][dy] && map[dx][dy] == 0) {
                    visited[dx][dy] = true;
                    priorityQueue.offer(new Node(dx, dy, node.count));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {

        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node node) {
            return count - node.count;
        }
    }
}
