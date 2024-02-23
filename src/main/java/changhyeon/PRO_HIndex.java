package changhyeon;

import java.util.Arrays;

public class PRO_HIndex {

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);

            if (smaller >= answer) {
                answer = Math.max(answer, smaller);
                continue;
            }

            break;
        }

        return answer;
    }
}
