package stageA20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10830 {
	static int[][] initial;
	static int[][] result;
	static int C;

	public static void matrixPower() {
		int[][] temp = new int[result.length][result.length];
		for (int N = 0; N < result.length; N++)
			for (int M = 0; M < result.length; M++)
				for (int K = 0; K < result.length; K++) {
					temp[N][K] += (result[N][M] % C) * (result[M][K] % C);
					temp[N][K] %= C;
				}
		result = temp;
	}

	public static void matrixProd() {
		int[][] temp = new int[result.length][result.length];
		for (int N = 0; N < result.length; N++)
			for (int M = 0; M < result.length; M++)
				for (int K = 0; K < result.length; K++) {
					temp[N][K] += (result[N][M] % C) * (initial[M][K] % C);
					temp[N][K] %= C;
				}
		result = temp;
	}

	public static void printMatrix() {
		for (int[] N : result) {
			for (int K : N)
				System.out.print(K + " ");
			System.out.println();
		}
	}

	private static void solution(long B) {
		if (B == 1) {
			return;
		}

		solution(B / 2);
		if (B % 2 == 1) {
			matrixPower();
			matrixProd();
			return;
		} else {
			matrixPower();
			return;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = 1000;
		initial = new int[N][N];
		result = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				initial[i][j] = Integer.parseInt(st.nextToken());
				result[i][j] = initial[i][j] % 1000;
			}
		}

		solution(B);
		printMatrix();
	}

}
