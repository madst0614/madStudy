package stageA21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2805 {
	static long[] tree;

	private static long getRotLen(long length) {
		long totLen = 0;

		for (int i = 0; i < tree.length; i++) {
			long tmp = tree[i] - length;
			if (tmp > 0)
				totLen += tmp;
		}
		return totLen;
	}

	private static int solution(long M) {
		int hi = 1_000_000_000;
		int lo = 0;
		int mid = (hi + lo) / 2;

		while (hi >= lo) {
			if (getRotLen(mid) < M)
				hi = mid - 1;
			else
				lo = mid + 1;

			mid = (hi + lo) / 2;
		}
		return hi;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		tree = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			tree[i] = Long.parseLong(st.nextToken());

		System.out.println(solution(M));
	}

}
