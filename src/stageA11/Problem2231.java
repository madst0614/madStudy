package stageA11;

import java.util.Scanner;

public class Problem2231 {

	public static int findConstructor(int N) {
		int resolveSum;
		int j = 1;
		for (int i = 1; i < N; i++) {
			j = i;
			resolveSum = j;
			while (j != 0) {
				resolveSum = resolveSum + (j % 10);
				j /= 10;
			}
			if (resolveSum == N)
				return i;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		System.out.println(Problem2231.findConstructor(N));
	}

}
