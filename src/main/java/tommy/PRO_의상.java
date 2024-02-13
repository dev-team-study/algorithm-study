package tommy;

import java.util.HashMap;
import java.util.Map;

public class PRO_의상 {
    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String, Integer> map = new HashMap<>();
            for(String[] clothe : clothes){
                String category = clothe[1];
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            for(int i : map.values()){
                answer *= (i + 1);
            }
            return answer - 1;
            // Stream 을 활용한 방식
//            return map.values().stream()
//                .map(i -> i + 1)
//                .reduce(1, (a, b) -> a * b) - 1;
        }
    }
}
