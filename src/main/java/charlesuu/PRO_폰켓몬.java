package charlesuu;

import java.util.HashSet;

public class PRO_폰켓몬 {

    public int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        if (pick >= set.size()) {
            answer = set.size();
        } else {
            answer = pick;
        }
        return answer;
    }
}