package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ_11723 {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> S = new ArrayList<>();
    private static int M, MAX_SIZE = 2;

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
    }

    private static void empty() {
        S.clear();
    }

    private static void all() {
        S = IntStream.range(1, 20)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void toggle(final int number) {
        if (!S.contains(number)) {
            S.add(number);
            return;
        }

        S.remove(Integer.valueOf(number));
    }

    private static void check(final int number) {
        if (!S.contains(number)) {
            System.out.println(0);
            return;
        }

        System.out.println(1);
    }

    private static void remove(final int number) {
        if (!S.contains(number)) {
            S.remove(Integer.valueOf(number));
        }
    }

    private static void add(final int number) {
        if (!S.contains(number)) {
            S.add(number);
        }
    }
}
