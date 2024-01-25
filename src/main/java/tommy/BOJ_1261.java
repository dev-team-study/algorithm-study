package tommy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1261 {
    static int m;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();   // 4
        n = sc.nextInt();   // 2
        sc.nextLine();
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }
        bfs(1,1);
    }

    private static void bfs(int x, int y) {
        // priority queue의 경우 Node의 count가 작은 것 부터 우선 탐색을 하기 때문에 보다 빠른 경로를 찾을 수 있다.
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == n && now.y == m) {
                System.out.println(now.count);
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > m){
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, now.count));
                }

                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, now.count + 1));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
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
