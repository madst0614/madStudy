package stageA10;

import java.util.Scanner;

public class Problem11729 {

	public static void move(int from, int to, StringBuffer sb) {
		sb.append(from + " " + to + "\n");
	}

	public static void hanoi(int N, int from, int temp, int to, StringBuffer sb) {
		if (N == 1) {
			move(from, to, sb);
			return;
		}

		hanoi(N - 1, from, to, temp, sb);
		move(from, to, sb);
		hanoi(N - 1, temp, from, to, sb);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		Problem11729.hanoi(N, 1, 2, 3, sb);
		int count = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '\r')
				;
			count++;
		}

		System.out.println((count / 4) + "\n" + sb);
	}

}
