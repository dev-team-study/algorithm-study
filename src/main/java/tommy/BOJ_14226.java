package tommy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14226 {

    static boolean[][] visited = new boolean[1001][1001];   //[clipboard][total]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();

        bfs(s);
    }

    private static void bfs(int s) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1, 0));
        visited[0][1] = true;

        while (!queue.isEmpty()){
            Node current = queue.poll();

            if (current.total == s){
                System.out.println(current.time);
                return;
            }

            // 1. 화면에 있는 이모티콘 클립 보드에 저장
            queue.offer(new Node(current.total, current.total, current.time + 1));

            // 2. 클립보드에 있는 이모티콘 붙여넣기
            if (current.clipboard != 0 && current.total + current.clipboard <= s && !visited[current.clipboard][current.total + current.clipboard]) {
                queue.offer(new Node(current.clipboard, current.total + current.clipboard, current.time + 1));
                visited[current.clipboard][current.total + current.clipboard] = true;
            }

            // 3. 화면에 있는 이모티콘 중 하나 삭제
            if (current.total >= 1 && !visited[current.clipboard][current.total - 1]) {
                queue.offer(new Node(current.clipboard, current.total - 1, current.time + 1));
                visited[current.clipboard][current.total + current.clipboard] = true;
            }
        }
    }

    public static class Node{
        int clipboard;
        int total;
        int time;

        public Node(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
}
