package stageA21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2110 {
	static long[] house;

	private static long solution(int C) {

		long hi = house[house.length - 1];
		long lo = 1;
		long mid = (hi + lo) / 2;

		while (hi >= lo) {

			int count = 1;
			int prev = 0;

			for (int i = 1; i < house.length; i++) {
				if (mid <= house[i] - house[prev]) {
					count++;
					prev = i;
				}
			}

			if (count < C)
				hi = mid - 1;
			else
				lo = mid + 1;

			mid = (hi + lo) / 2;
		}

		return hi;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		house = new long[N];
		for (int i = 0; i < N; i++) {
			house[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(house);
		System.out.println(solution(C));
	}

}
