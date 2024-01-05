package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11723 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static int bit, M, MAX_SIZE = 2;

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            String order = line[0];
            int number = 0;

            if (line.length == MAX_SIZE) {
                number = Integer.parseInt(line[1]);
            }

            switch (order) {
                case "add":
                    add(number);
                    break;
                case "remove":
                    remove(number);
                    break;
                case "check":
                    check(number);
                    break;
                case "toggle":
                    toggle(number);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
                default:
                    throw new RuntimeException("잘못된 입력입니다.");
            }
        }

        System.out.println(stringBuilder.toString());
    }

    private static void empty() {
        bit = 0;
    }

    private static void all() {
        bit = (1 << 20) - 1;
    }

    private static void toggle(final int number) {
        bit = bit ^ (1 << number - 1);

    }

    private static void check(final int number) {
        if ((bit & (1 << (number - 1))) == 0) {
            stringBuilder.append("0\n");
            return;
        }

        stringBuilder.append("1\n");
    }

    private static void remove(final int number) {
        bit = bit & ~(1 << (number - 1));
    }

    private static void add(final int number) {
        bit = bit | (1 << (number - 1));
    }
}
