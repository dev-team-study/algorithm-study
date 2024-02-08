package tommy;

import java.util.HashSet;
import java.util.Set;

public class PRO_폰켓몬 {
    /*
    최대 반환 수 : N / 2
    같은 숫자인 경우 종류는 1개로 취급
    */
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        return set.size() > nums.length / 2 ? nums.length / 2 : set.size();
    }
}
