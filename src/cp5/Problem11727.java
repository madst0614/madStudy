package cp5;

import java.util.Scanner;

public class Problem11727 {
	static Integer[] num;

	private static void solution(int n) {
		num[0] = 1;
		num[1] = 1;

		for (int i = 2; i <= n; i++) {
			num[i] = num[i - 1] + 2 * num[i - 2];
			num[i] %= 10_007;
		}
		System.out.println(num[n]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		num = new Integer[n + 1];

		solution(n);
	}

}
