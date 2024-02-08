package tommy;

import java.util.HashMap;
import java.util.Map;

public class PRO_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        for(String p : participant){
            map.put(p, map.getOrDefault(p,0) + 1);
        }

        for(String c : completion){
            Integer res = map.get(c);
            if(res == 1){
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        String answer = "";
        for(String key : map.keySet()){
            answer = key;
        }
        return answer;
    }
}
