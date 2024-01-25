package tommy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549 {
    static int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n, k);
        }
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == k) {
                System.out.println(visited[now] - 1);
                return;
            }

            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                queue.offer(now * 2);
                visited[now * 2] = visited[now];
            }
            if (now - 1 >= 0 && visited[now - 1] == 0) {
                queue.offer(now - 1);
                visited[now - 1] = visited[now] + 1;
            }
            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                queue.offer(now + 1);
                visited[now + 1] = visited[now] + 1;
            }
        }
    }

}
