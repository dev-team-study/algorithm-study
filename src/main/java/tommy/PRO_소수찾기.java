package tommy;

import java.util.HashSet;
import java.util.Set;

public class PRO_소수찾기 {
    static boolean[] visited = new boolean[7];
    static Set<Integer> set = new HashSet<>();
    static String number = "";

    /*
     * Time Complexity : O(N ^ 2)
     * Space Complexity : O(N)
     */
    public int solution(String numbers) {
        number = numbers;
        // Initialization
        dfs("", 0);

        int answer = 0;
        for(int i : set){
            if(isPrime(i)){
                answer++;
            }
        }

        return answer;
    }

    void dfs(String s, int depth){
        if(depth == number.length()){
            return;
        }

        for(int i = 0; i < number.length(); i++){
            if (!visited[i]){
                visited[i] = true;
                set.add(Integer.valueOf(s + number.charAt(i)));
                dfs(s + number.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int n){
        if (n < 2){
            return false;
        }
        for(int i = 2; i <= n / 2; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}
