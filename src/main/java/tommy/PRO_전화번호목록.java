package tommy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PRO_전화번호목록 {

    /*
     * Space Complexity : O(N) ==> map에 phone_book의 크기만큼 저장 될 수 있기 때문에
     * Time Complexity : O(N log N) ==> Arrays.sort() // for문이 중첩되긴 하지만 전화번호의 최대 길이는 20자이므로 N log N 이 우세
     */
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Boolean> map = new HashMap<>();
        Arrays.sort(phone_book);
        for(String phone : phone_book){
            // 검증
            for(int i = 0; i <= phone.length(); i++){
                String partition = phone.substring(0, i);
                if(map.containsKey(partition)){
                    answer = false;
                }
            }
            map.put(phone, true);
        }
        return answer;
    }
}
