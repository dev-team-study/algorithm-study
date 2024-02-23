package changhyeon;

import java.util.HashSet;
import java.util.Set;

public class PRO_소수찾기 {

    private boolean[] visited;
    private Set<String> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == '0')
                continue;
            visited = new boolean[numbers.length()];
            visited[i] = true;
            recursive(numbers, 0, String.valueOf(numbers.charAt(i)));
        }

        return set.size();
    }

    private void recursive(String numbers, int count, String str) {
        if (count == numbers.length()) {
            return;
        }

        if (isPrime(str)) {
            set.add(str);
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                recursive(numbers, count + 1, str + String.valueOf(numbers.charAt(i)));
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(String str) {
        int number = Integer.parseInt(str);
        int sum = 0;

        if (number == 0 || number == 1)
            return false;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
