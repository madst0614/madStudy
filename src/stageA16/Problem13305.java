package stageA16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13305 {
	static long[] distance;
	static long[] oilPrice;

	private static long findMinCost() {
		long cost = 0;
		long tmpOP = Integer.MAX_VALUE;
		for (int i = 0; i < oilPrice.length; i++) {
			if (oilPrice[i] < tmpOP) {
				tmpOP = oilPrice[i];
			}
			cost += tmpOP * distance[i];

		}
		return cost;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		distance = new long[N - 1];
		oilPrice = new long[N - 1];

		// 거리
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			distance[i] = Long.parseLong(st.nextToken());

		// 기름 가격
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			oilPrice[i] = Long.parseLong(st.nextToken());

		System.out.println(findMinCost());
	}

}
