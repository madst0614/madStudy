package stageA15;

import java.util.Scanner;

public class Problem10844 {

	static long[][] number;
	static long mod = 1000000000;

	public static long countingStairs(int N) {
		if (N == 1)
			return 9;
		long count = 0;
		for (int i = 2; i <= N; i++)
			for (int j = 0; j < 10; j++) {
				if (j - 1 < 0)
					number[i][j] = number[i - 1][j + 1] % mod;
				else if (j + 1 > 9)
					number[i][j] = number[i - 1][j - 1] % mod;
				else {
					number[i][j] = (number[i - 1][j - 1] + number[i - 1][j + 1]) % mod;
				}
				if (i == N)
					count += number[i][j];
			}
		count %= 1000000000;
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.close();
		number = new long[N + 1][10];
		for (int i = 0; i < 10; i++) {
			if (i == 0)
				number[1][i] = 0;
			else
				number[1][i] = 1;
		}
		System.out.println(countingStairs(N));

	}

}
