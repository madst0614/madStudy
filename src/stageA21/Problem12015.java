package stageA21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12015 {
	static int[] num;
	static int[] cache;
	static int[] lcs;

	private static int lowerBound(int idx, int num) {
		int hi = idx;
		int lo = 0;
		int mid;
		while (hi > lo) {
			mid = lo + (hi - lo) / 2;

			if (num <= cache[mid])
				hi = mid;
			else
				lo = mid + 1;
		}
		return hi;
	}

	private static int solution() {
		int idx = 1;

		for (int i = 1; i < num.length; i++) {
			int tempIdx = lowerBound(idx, num[i]);

			if (cache[tempIdx] == 0) {
				lcs[i] = idx;
				idx++;
			} else {
				lcs[i] = lcs[tempIdx - 1] + 1;
			}
			cache[tempIdx] = num[i];
		}

		return idx - 1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		num = new int[N + 1];
		cache = new int[N + 1];
		lcs = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			num[i] = Integer.parseInt(st.nextToken());

		}

		System.out.println(solution());
	}

}
