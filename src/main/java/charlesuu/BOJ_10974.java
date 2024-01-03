package charlesuu;

import java.util.Scanner;
/*
 시간 복잡도 :
 공간 복잡도 :
 */

public class BOJ_10974 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] premutation = new int[N];
        for (int i = 0; i < N; i++)
            premutation[i] = i + 1;

        do {
            for (int i = 0; i < N; i++)
                System.out.print(premutation[i] + " ");
            System.out.println();
        } while (nextPremutation(premutation, 0, N));
    }

    public static boolean nextPremutation(int[] arr, int s, int e) {
        int i = e - 1;
        for (; i > s; i--) {
            if (arr[i - 1] > arr[i])
                continue;
            else
                break;
        }
        if (i == 0) return false;

        int j = e - 1;
        for (; j >= i; j--) {
            if (arr[j] < arr[i - 1])
                continue;
            else
                break;
        }

        int tmp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = tmp;
        j = e - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
