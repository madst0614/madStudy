package stageA21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1300 {

	private static long countQ(long n, long mid) {
		long count = 0;

		for (int i = 1; i <= n; i++) {
			long q = mid / i;
			if (q > n)
				q = n;
			count += q;
		}

		return count;
	}

	private static long solution(long N, long K) {

		long hi = K;
		long lo = 1;
		long mid = (hi + lo) / 2;

		// hi는 K가 속한 N의 범위를 구해준다.
		while (hi > lo) {
			if (countQ(N, mid) >= K)
				hi = mid;
			else
				lo = mid + 1;

			mid = (hi + lo) / 2;

		}
		return hi;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		long K = Long.parseLong(br.readLine());

		System.out.println(solution(N, K));

	}

}
