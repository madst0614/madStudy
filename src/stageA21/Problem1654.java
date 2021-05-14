package stageA21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1654 {
	static long[] line;

	private static int calRotNum(long rotLen) {
		int count = 0;

		for (int i = 0; i < line.length; i++) {
			count += line[i] / rotLen;
		}
		return count;
	}

	private static long solution(int N) {
		long hi = Integer.MAX_VALUE;
		long lo = 1;
		long mid = (hi + lo) / 2;

		while (hi >= lo) {
			if (calRotNum(mid) >= N)
				lo = mid + 1;
			else
				hi = mid - 1;

			mid = (hi + lo) / 2;
		}

		return hi;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		line = new long[K];

		for (int i = 0; i < K; i++)
			line[i] = Long.parseLong(br.readLine());

		System.out.println(solution(N));
	}

}
