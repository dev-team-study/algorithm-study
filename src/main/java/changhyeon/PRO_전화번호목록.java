package changhyeon;

import java.util.Arrays;

public class PRO_전화번호목록 {

    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        System.out.println(Arrays.toString(phone_book));

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
