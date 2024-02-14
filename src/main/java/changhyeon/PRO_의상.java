package changhyeon;

import java.util.HashMap;
import java.util.Map;

public class PRO_의상 {

    public int solution(String[][] clothes) {
        int sum = 1;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }

        for (int num : map.values()) {
            sum *= (num + 1);  // 안 입었을 때의 경우 1 추가
        }

        return sum - 1;
    }
}
