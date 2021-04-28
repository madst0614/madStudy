package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2565 {
	static int[] wire;
	static int[] lis;

	private static void orderList(int N) {
		int[] temp = new int[N];
		int index = 0;
		for (int i = 0; i < wire.length; i++) {
			if (wire[i] == 0)
				continue;
			else
				temp[index++] = wire[i];
		}
		wire = temp;
	}

	private static int findMinWire(int N) {
		int maxLIS = 0;

		for (int i = wire.length - 1; i >= 0; i--) {
			if (i == wire.length - 1) {
				lis[i]++;
				maxLIS = lis[i];
				continue;
			}

			for (int j = i + 1; j < wire.length; j++) {
				if (wire[i] < wire[j]) {
					if (lis[i] < lis[j])
						lis[i] = lis[j];
				}

			}

			lis[i]++;
			if (lis[i] > maxLIS)
				maxLIS = lis[i];
		}

		return N - maxLIS;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int maxNum = 500;
		wire = new int[maxNum + 1];
		lis = new int[maxNum + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			wire[num] = Integer.parseInt(st.nextToken());
		}

		orderList(N);
		System.out.println(findMinWire(N));
	}

}
