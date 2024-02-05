package charlesuu;

import java.util.Scanner;

public class BOJ_15662 {
	public static int T;
	public static int[][] a;

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		a = new int[T + 1][8];
		sc.nextLine();
		for (int i = 1; i <= T; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				a[i][j] = line.charAt(j) - '0';
			}
		}

		int K = sc.nextInt();
		while (K-- > 0) {
			int num = sc.nextInt();
			int dir = sc.nextInt();

			if (dir == 1) {
				rotateClockwise(a[num]);
			} else {
				rotateCounterClockwise(a[num]);
			}

			int dir_left = dir;
			for (int i = num; i >= 2; i--) {
				if (dir_left == -1) {
					if (a[i][5] != a[i - 1][2]) {
						rotateClockwise(a[i - 1]);
						dir_left *= -1;
						continue;
					}
				} else {
					if (a[i][7] != a[i - 1][2]) {
						rotateCounterClockwise(a[i - 1]);
						dir_left *= -1;
						continue;
					}
				}
				break;
			}

			int dir_right = dir;
			for (int i = num; i < T; i++) {
				if (dir_right == -1) {
					if (a[i][1] != a[i + 1][6]) {
						rotateClockwise(a[i + 1]);
						dir_right *= -1;
						continue;
					}
				} else {
					if (a[i][3] != a[i + 1][6]) {
						rotateCounterClockwise(a[i + 1]);
						dir_right *= -1;
						continue;
					}
				}
				break;
			}
		}

		int count = 0;
		for (int i = 1; i < T + 1; i++) {
			if (a[i][0] == 1) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static void rotateClockwise(int[] aa) {
		int tmp = aa[7];
		for (int i = 6; i >= 0; i--) {
			aa[i + 1] = aa[i];
		}
		aa[0] = tmp;
	}

	public static void rotateCounterClockwise(int[] aa) {
		int tmp = aa[0];
		for (int i = 1; i < 8; i++) {
			aa[i - 1] = aa[i];
		}
		aa[7] = tmp;
	}

}
