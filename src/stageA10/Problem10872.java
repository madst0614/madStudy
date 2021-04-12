package stageA10;

import java.util.Scanner;

public class Problem10872 {

	public static int factorial(int N) {
		if (N == 1 || N == 0)
			return 1;
		return N * factorial(N - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(Problem10872.factorial(N));
	}

}
