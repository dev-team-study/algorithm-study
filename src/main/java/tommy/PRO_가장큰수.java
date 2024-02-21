package tommy;

import java.util.Arrays;

public class PRO_가장큰수 {

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            strings[i] = numbers[i] + "";
        }

        Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo((s1 + s2)));
        StringBuilder sb = new StringBuilder();
        for(String s : strings){
            sb.append(s);
        }
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}
