package tommy;

public class PRO_네트워크 {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                recursion(computers, i);
            }
        }
        return answer;
    }

    void recursion(int[][] computers, int startIndex){
        visited[startIndex] = true;
        for(int i = 0; i < computers.length; i++){
            if(computers[startIndex][i] == 1 && !visited[i]){
                recursion(computers, i);
            }
        }
    }
}
