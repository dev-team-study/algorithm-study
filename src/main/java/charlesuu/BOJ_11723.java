package charlesuu;

import java.util.Scanner;

public class BOJ_11723 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = 20;
		int m = sc.nextInt();
		sc.nextLine();
		int s = 0;

		StringBuilder sb = new StringBuilder();

		while (m-- > 0) {
			String[] line = sc.nextLine().split(" ");

			if (line[0].equals("add")) {
				int x = Integer.valueOf(line[1]) - 1;
				s = (s | (1 << x));
			} else if (line[0].equals("remove")) {
				int x = Integer.valueOf(line[1]) - 1;
				s = (s & ~(1 << x));
			} else if (line[0].equals("check")) {
				int x = Integer.valueOf(line[1]) - 1;
				int res = (s & (1 << x));
				if (res == 0) {
					sb.append("0\n");
				} else {
					sb.append("1\n");
				}
			} else if (line[0].equals("toggle")) {
				int x = Integer.valueOf(line[1]) - 1;
				s = (s ^ (1 << x));
			} else if (line[0].equals("all")) {
				s = (1 << n) - 1;
			} else if (line[0].equals("empty")) {
				s = 0;
			}
		}
		System.out.print(sb);
	}
}

