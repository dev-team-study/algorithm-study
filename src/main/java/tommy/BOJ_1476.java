package tommy;


import java.io.*;
import java.util.*;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int E = 0;
        int S = 0;
        int M = 0;
        int year = 0;
        while (true) {
            year++;
            E++;
            S++;
            M++;
            if (E == 16) E = 1;
            if (S == 29) S = 1;
            if (M == 20) M = 1;
            if (e == E && m == M && S == s) break;
        }
        System.out.print(year);
    }
}
