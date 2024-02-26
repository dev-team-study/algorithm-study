package changhyeon;

public class PRO_전력망둘로나누기 {

    private final static String[] stringArray = {"A", "E", "I", "O", "U"};
    private final static int MAX_NUMBER = 5;
    private static boolean flag = false;
    private static int sum = 0;

    public int solution(String word) {
        recursive(0, "", word);

        return sum - 1;
    }

    private void recursive(int count, String currentWord, String word) {
        if (count > MAX_NUMBER || flag) {
            return;
        }

        sum++;

        if (currentWord.equals(word)) {
            flag = true;
        }

        for (int i = 0; i < stringArray.length; i++) {
            recursive(count + 1, currentWord + stringArray[i], word);
        }
    }
}
