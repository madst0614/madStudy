package stageA10;

import java.util.Scanner;

public class Problem10870 {
	public static int fib(int N) {
		if (N == 0)
			return 0;
		if (N == 1)
			return 1;
		return fib(N - 1) + fib(N - 2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(Problem10870.fib(N));
	}

}
