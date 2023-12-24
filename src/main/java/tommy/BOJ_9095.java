package tommy;

import java.util.Scanner;

public class BOJ_9095 {
    int[] nums = new int[11];

    /*
     * 시간 복잡도 : O(1) -> 상수 시간 복잡도 이기 때문에
     * 공간 복잡도 : O(1) -> 11개의 공간만 필요하므로
     */
    private void solution(int[] inputs) {
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 4;
        for (int i = 3; i < 11; i++) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
        for (int input : inputs) {
            System.out.println(nums[input - 1]);
        }
    }

    public static void main(String[] args) {
        BOJ_9095 BOJ9095 = new BOJ_9095();
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        int[] inputs = new int[numbers];

        for (int i = 0; i < numbers; i++) {
            inputs[i] = sc.nextInt();
        }
        BOJ9095.solution(inputs);
    }
}
