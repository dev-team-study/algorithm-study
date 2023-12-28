package changhyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1759 {

    private static int L, C;
    private static String vows = "aeiou";
    private static List<String> con = new ArrayList<>();
    private static List<String> vow = new ArrayList<>();
    private static List<String> temp = new ArrayList<>();
    private static List<String> result = new ArrayList<>();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] line = bufferedReader.readLine().split(" ");
        L = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);

        String[] strArr = bufferedReader.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            String alpabet = strArr[i];
            if (vows.contains(alpabet))
                vow.add(alpabet);
            else
                con.add(alpabet);
        }

        for (int i = 1; i <= L - 2; i++) {
            vowDfs(i, 0, 0);
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static void vowDfs(int depth, int index, int cnt) {
        if (cnt == depth) {
            conDfs(L - depth, 0, 0);
            return;
        }
        for (int i = index; i < vow.size(); i++) {
            temp.add(vow.get(i));
            vowDfs(depth, i + 1, cnt + 1);
            temp.remove(vow.get(i));
        }
    }

    public static void conDfs(int depth, int index, int cnt) {
        if (cnt == depth) {
            Collections.sort(temp);
            String str = String.join("", temp);
            result.add(str);
            return;
        }
        for (int i = index; i < con.size(); i++) {
            temp.add(con.get(i));
            conDfs(depth, i + 1, cnt + 1);
            temp.remove(con.get(i));
        }
    }
}
