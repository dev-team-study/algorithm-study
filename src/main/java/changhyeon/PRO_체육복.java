package changhyeon;

import java.util.ArrayList;
import java.util.Arrays;

public class PRO_체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> reserveList = new ArrayList<>();
        ArrayList<Integer> lostList = new ArrayList<>();
        int count = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i : reserve) {
            reserveList.add(i);
        }

        for (int i : lost) {
            lostList.add(i);
        }

        for (int num : lost) {
            if (lostList.size() != 0 && reserveList.size() != 0 && reserveList.contains(num)) {
                lostList.remove(Integer.valueOf(num));
                reserveList.remove(Integer.valueOf(num));
                count++;
            }
        }

        for (int num : lostList) {
            if (reserveList.size() != 0 && reserveList.contains(num - 1)) {
                reserveList.remove(Integer.valueOf(num - 1));
                count++;
                continue;
            }
            if (reserveList.size() != 0 && reserveList.contains(num + 1)) {
                reserveList.remove(Integer.valueOf(num + 1));
                count++;
                continue;
            }

        }

        return n - lost.length + count;
    }
}
