package tommy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {

    /*
     * 시간 복잡도 : O(10^6) -> for 문 10^5 * number 순회 10^1
     * 공간 복잡도 : O(1) -> 별다르게 할당하는 곳이 없으므로
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int numOfBroken = Integer.parseInt(st.nextToken());
        boolean[] brokenNumbers = new boolean[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfBroken; i++) {
            brokenNumbers[Integer.parseInt(st.nextToken())] = true;
        }

        int count = Math.abs(target - 100); // default : 100번

        for (int i = 0; i < 999999; i++) {
            String stringNumber = String.valueOf(i);
            boolean isBreak = false;
            for (char c : stringNumber.toCharArray()) {
                if (brokenNumbers[Integer.valueOf(String.valueOf(c))]) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                count = Math.min(count, Math.abs(target - i) + stringNumber.length());
            }

        }

        System.out.println(count);

    }
}
