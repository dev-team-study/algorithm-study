package tommy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562 {
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int I;
    static int curX, curY, objX, objY;
    static int[][] arr;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            I = sc.nextInt();
            arr = new int[I][I];
            visited = new boolean[I][I];

            curX = sc.nextInt();
            curY = sc.nextInt();
            objX = sc.nextInt();
            objY = sc.nextInt();

            bfs();
            sb.append(arr[objX][objY]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{curX, curY});
        visited[curX][curY] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0];
            int ny = poll[1];

            for (int i = 0; i < 8; i++) {
                int newX = nx + dx[i];
                int newY = ny + dy[i];

                if (newX >= 0 && newX < I && newY >= 0 && newY < I) {
                    if (!visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        arr[newX][newY] = arr[nx][ny] + 1;
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}
