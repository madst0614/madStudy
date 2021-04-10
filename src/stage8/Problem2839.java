package stage8;

import java.util.Scanner;

public class Problem2839 {

	public static void minBag(int N) {
		int maxFive;
		int minBag = 5001;
		
		maxFive = N / 5;
		for (int i = 0; i <= maxFive && (N - 5 * i) >= 0; i++) {
			int weight = N;
			weight -= 5 * i;
			if (weight % 3 != 0)
				continue;
			if (minBag > i + (weight / 3))
				minBag = i + (weight / 3);
		}
		if (minBag == 5001)
			System.out.println(-1);
		else
			System.out.println(minBag);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.close();

		Problem2839.minBag(N);
	}

}
