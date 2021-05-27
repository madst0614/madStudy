package cp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10819 {
	static int[] list;
	static int[] tempList;
	static boolean[] num;
	static int max;

	private static void solution(int N) {
		if (N == list.length) {
			int tempMax = 0;
			for (int i = 0; i < tempList.length - 1; i++) {
				tempMax += Math.abs(tempList[i] - tempList[i + 1]);

			}

			if (max < tempMax)
				max = tempMax;
		}

		for (int i = 0; i < list.length; i++) {
			if (!num[i]) {
				num[i] = true;
				tempList[N] = list[i];
				solution(N + 1);
				num[i] = false;
			}

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		list = new int[N];
		tempList = new int[N];
		num = new boolean[N];
		max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		solution(0);
		System.out.println(max);
	}

}
