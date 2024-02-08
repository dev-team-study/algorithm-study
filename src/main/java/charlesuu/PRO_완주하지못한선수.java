package charlesuu;

import java.util.HashMap;
import java.util.Map;

public class PRO_완주하지못한선수 {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> hashMap = new HashMap<>();

        for (String p : participant) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            hashMap.put(c, hashMap.get(c) - 1);
        }

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
