package changhyeon;

import java.util.HashMap;
import java.util.Map;

public class PRO_완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (!map.containsKey(participant[i])) {
                map.put(participant[i], 1);
                continue;
            }

            map.put(participant[i], map.get(participant[i]) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }

        for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() >= 1) {
                return entrySet.getKey();
            }
        }

        return answer;
    }
}
