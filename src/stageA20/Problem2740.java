package stageA20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2740 {
	static int[][] A;
	static int[][] B;
	static int[][] C;

	public static void matrixProd() {
		for (int N = 0; N < A.length; N++)
			for (int M = 0; M < A[N].length; M++)
				for (int K = 0; K < B[M].length; K++)
					C[N][K] += A[N][M] * B[M][K];
	}

	public static void printMatrix() {
		for (int[] N : C) {
			for (int K : N)
				System.out.print(K + " ");
			System.out.println();
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int K = Integer.parseInt(st.nextToken());

		B = new int[M][K];
		C = new int[N][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++)
				B[i][j] = Integer.parseInt(st.nextToken());
		}

		matrixProd();
		printMatrix();
	}

}
