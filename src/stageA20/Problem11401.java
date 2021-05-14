package stageA20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11401 {
	static long D;

	private static long power(long A, long B) {
		if (B == 1)
			return A % D;

		long subSol = power(A, B / 2) % D;
		if (B % 2 == 1)
			return (((subSol * subSol) % D) * (A % D)) % D;
		else
			return (subSol * subSol) % D;

	}

	private static long solution(long N, long K) {
		long numerator = 1;
		long denominator = 1;

		for (int i = (int) N; i > 1; i--) {
			numerator *= i;
			numerator %= D;
		}

		for (int i = (int) K; i > 1; i--) {
			denominator *= i;
			denominator %= D;
		}

		for (int i = (int) (N - K); i > 1; i--) {
			denominator *= i;
			denominator %= D;
		}

		denominator = power(denominator, D - 2);

		return ((numerator % D) * (denominator % D)) % D;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		D = 1_000_000_007;

		System.out.println(solution(N, K));
	}

}
