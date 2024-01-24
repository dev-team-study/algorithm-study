package tommy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_13913 {
    static int[] parent;
    static int[] time;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
        } else {
            bfs(n, k);
            System.out.println(time[k] - 1);

            Stack<Integer> stack = new Stack<>();
            stack.push(k);
            int index = k;
            while (index != n) {
                stack.push(parent[index]);
                index = parent[index];
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb);
        }
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        parent = new int[100001];
        time = new int[100001];
        queue.offer(n);
        time[n] = 1;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            if (now == k) {
                return;
            }
            if (now * 2 <= 100000 && time[now * 2] == 0) {
                parent[now * 2] = now;
                time[now * 2] = time[now] + 1;
                queue.offer(now * 2);
            }
            if (now + 1 <= 100000 && time[now + 1] == 0) {
                parent[now + 1] = now;
                time[now + 1] = time[now] + 1;
                queue.offer(now + 1);
            }
            if (now - 1 >= 0 && time[now - 1] == 0) {
                parent[now - 1] = now;
                time[now - 1] = time[now] + 1;
                queue.offer(now - 1);
            }
        }
    }
}
