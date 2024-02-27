package changhyeon;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_전력망둘로나누기 {

    private static int[][] map;

    public int solution(int n, int[][] wires) {
        int answer = n;

        map = new int[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            map[from][to] = 1;
            map[to][from] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            map[from][to] = 0;
            map[to][from] = 0;
            answer = Math.min(answer, bfs(n, from));
            map[from][to] = 1;
            map[to][from] = 1;
        }

        return answer;
    }

    private int bfs(int n, int from) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 1;
        deque.add(from);
        visited[from] = true;

        while (!deque.isEmpty()) {
            int temp = deque.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && map[temp][i] == 1) {
                    visited[i] = true;
                    deque.add(i);
                    count++;
                }
            }
        }

        return (int)Math.abs(count - (n - count));
    }
}
