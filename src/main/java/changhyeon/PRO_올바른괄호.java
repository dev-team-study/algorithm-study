package changhyeon;

public class PRO_올바른괄호 {

    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        String[] arr = s.split("");

        for (int i = 0; i < arr.length; i++) {
            if (count == 0 && arr[i].equals(")")) {
                return false;
            }

            if (arr[i].equals("(")) {
                count++;
            } else {
                count--;
            }
        }

        return count == 0 ? true : false;
    }
}
