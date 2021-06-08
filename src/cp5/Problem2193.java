package cp5;

import java.util.Scanner;

public class Problem2193 {
	static long[][] num;

	private static void solution(int N) {
		num[1][0] = 0;
		num[1][1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 1; j++) {
				num[i][0] = num[i - 1][0] + num[i - 1][1];
				num[i][1] = num[i - 1][0];
			}
		}

		System.out.println(num[N][0] + num[N][1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		num = new long[N + 1][2];

		solution(N);
	}

}
