package cp5;

import java.util.Scanner;

public class Problem11057 {
	static int[][] num;
	static int mod = 10_007;

	private static int solution(int N) {
		int count = 0;

		for (int i = 0; i <= 9; i++) {
			num[1][i] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					num[i][j] += num[i - 1][k];
					num[i][j] %= mod;
				}
			}
		}

		for (int i = 0; i <= 9; i++) {
			count += num[N][i];
			count %= mod;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		num = new int[N + 1][10];

		System.out.println(solution(N));

	}

}
