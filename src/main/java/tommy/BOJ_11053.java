package tommy;

import java.util.Scanner;

public class BOJ_11053 {
    static int N;
    static int[] A;
    static int[] dp;
    /*
     * 순열을 하나씩 방문 할 때 마다 이전 순열들과 값을  비교해 갱신하는 방식
     * 시간 복잡도 O(N^2) : 단순한 알고리즘으로 시간복잡도가 나름 좀 아쉽다..
     * 공간 복잡도 O(N)
     */
    private static void solution() {
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }

    /*
     * 이진 탐색 방법.
     * 시간 복잡도 : O(NlogN)
     * 공간 복잡도 : O(N)
     */
    private static void solution2() {
        int[] LIS = new int[N];

        // LIS 초기 값으로 첫 번째 수열의 값을 가짐
        LIS[0] = A[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {
            int key = A[i];

            // 만약 key가 LIS의 마지막 값 보다 클 경우 교체
            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            } else {
                // Lower Bound 이분탐색을 진행
                int lo = 0;
                int hi = lengthOfLIS;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (LIS[mid] < key) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                LIS[lo] = key;
            }
        }

        System.out.println(lengthOfLIS);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        solution2();
    }
}
