package tommy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
    static int N;
    static int K;
    static int[] visited = new int[100001];

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        int index = node;
        visited[index] = 1;
        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (n == K) {
                return visited[n] - 1;
            }
            if (n - 1 >= 0 && visited[n - 1] == 0) {
                queue.offer(n - 1);
                visited[n - 1] = visited[n] + 1;
            }

            if (n + 1 <= 100000 && visited[n - 1] == 0) {
                queue.offer(n + 1);
                visited[n + 1] = visited[n] + 1;
            }

            if (2 * n <= 100000 && visited[2 * n] == 0) {
                queue.offer(2 * n);
                visited[2 * n] = visited[n] + 1;
            }
        }
        return -1;
    }
}
