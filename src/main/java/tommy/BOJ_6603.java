package tommy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6603 {
    static int k;
    static int[] s;
    static boolean[] visited;

    /*
     * 시간 복잡도 : O(kC6)
     * 공간 복잡도 : O(k)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String test = br.readLine();
            if (test.equals("0")) break;
            String[] input = test.split(" ");
            k = Integer.parseInt(input[0]);
            s = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(input[i + 1]);
            }
            dfs(0, 0);
            System.out.println();   // 한칸 띄우기
        }
    }

    private static void dfs(int depth, int prevNum) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    System.out.print(s[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = prevNum; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
