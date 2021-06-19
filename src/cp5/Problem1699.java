package cp5;

import java.util.Scanner;

public class Problem1699 {
	static int[] num;

	private static void solution(int N) {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= Math.sqrt(i) + 1; j++) {
				if (i == j * j) {
					num[i] = 1;
				} else if (i - j * j > 0) {
					int temp = num[j * j] + num[i - j * j];
					if (num[i] == 0)
						num[i] = temp;
					else if (num[i] > temp)
						num[i] = temp;
				}

			}
		}

		System.out.println(num[N]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.close();
		num = new int[N + 1];

		solution(N);
	}

}
