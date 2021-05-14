package stageA20;

import java.util.Scanner;

public class Problem11444 {
	static long[][] initial = { { 1, 1 }, { 1, 2 } };
	static long[][] result = { { 1, 1 }, { 1, 2 } };
	static long[] fibNum = { 0, 1 };
	static long C = 1_000_000_007;

	public static void matrixPower() {
		long[][] temp = new long[result.length][result.length];
		for (int N = 0; N < result.length; N++)
			for (int M = 0; M < result.length; M++)
				for (int K = 0; K < result.length; K++) {
					temp[N][K] += (result[N][M] % C) * (result[M][K] % C);
					temp[N][K] %= C;
				}
		result = temp;
	}

	public static void matrixProd() {
		long[][] temp = new long[result.length][result.length];
		for (int N = 0; N < result.length; N++)
			for (int M = 0; M < result.length; M++)
				for (int K = 0; K < result.length; K++) {
					temp[N][K] += (result[N][M] % C) * (initial[M][K] % C);
					temp[N][K] %= C;
				}
		result = temp;
	}

	public static void matrixProdResult() {
		long[] temp = new long[fibNum.length];
		for (int i = 0; i < fibNum.length; i++)
			for (int j = 0; j < fibNum.length; j++)
				temp[i] = fibNum[j] * result[j][i];
		fibNum = temp;
	}

	private static void getFibPower(long N) {
		if (N == 0 || N == 1) {
			return;
		}

		getFibPower(N / 2);

		if (N % 2 == 1) {
			matrixPower();
			matrixProd();
			return;
		}

		matrixPower();
		return;

	}

	private static void getFibNum(long N) {
		if (N == 1) {
			System.out.println(fibNum[1]);
			return;
		}
		getFibPower(N / 2);
		matrixProdResult();

		if (N % 2 == 1)
			System.out.println(fibNum[1]);
		else
			System.out.println(fibNum[0]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		sc.close();

		getFibNum(N);
	}

}
