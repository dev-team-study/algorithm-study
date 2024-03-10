package changhyeon;

public class PRO_네트워크 {

    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, computers, visited);
            }
        }

        return count;
    }

    private void dfs(int index, int[][] computers, boolean[] visited) {
        visited[index] = true;
        for (int i = 0; i < computers[index].length; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}
