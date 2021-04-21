package stageA15;

// 출처 : https://developer-mac.tistory.com/65
import java.util.Scanner;

public class Problem1463 {
	static int[] minOp;

	public static int findMinOp(int N) {

		if (N == 1)
			return 0;

		if (minOp[N] != 0)
			return minOp[N];

		minOp[N] = findMinOp(N - 1) + 1;

		if (N % 3 == 0) {
			int temp = findMinOp(N / 3) + 1;
			if (temp < minOp[N])
				minOp[N] = temp;
		}

		if (N % 2 == 0) {
			int temp = findMinOp(N / 2) + 1;
			if (temp < minOp[N])
				minOp[N] = temp;
		}

		return minOp[N];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.close();

		minOp = new int[1000001];

		System.out.println(findMinOp(N));
	}

}
