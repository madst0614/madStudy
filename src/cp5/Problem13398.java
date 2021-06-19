package cp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13398 {
	static long[] list;

	private static long solution(int N) {
		long max = Integer.MIN_VALUE;
		long pMinus = 0;
		long pSum = 0;
		long sum = 0;

		for (int i = 0; i < list.length; i++) {
			if (list[i] < 0) {
				if (list[i] > max)
					max = list[i];

				if (pMinus == 0) {
					pMinus = list[i];
					pSum = sum;
				} else {
					if (pSum + list[i] > sum) {
						pSum += list[i];
					} else {
						pSum = sum;
					}
				}

				if (sum + list[i] > 0)
					sum += list[i];
				else
					sum = list[i];

			} else if (list[i] >= 0) {
				if (sum < 0)
					sum = 0;
				sum += list[i];
				pSum += list[i];
			}

			if (sum > max)
				max = sum;
			if (pSum != 0 && pSum > max)
				max = pSum;

		}
		if (sum == 0)
			return 0;
		else
			return max;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		list = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < list.length; i++) {
			list[i] = Long.parseLong(st.nextToken());
		}

		System.out.print(solution(N));
		br.close();
	}

}
