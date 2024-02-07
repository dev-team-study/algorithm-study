package changhyeon;

import java.util.HashSet;
import java.util.Set;

public class PRO_폰켓몬 {

    public int solution(int[] nums) {
        int N = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        if (set.size() >= N) {
            return N;
        }

        return set.size();
    }
}
