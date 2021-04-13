package stageA11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2798 {

	public static int[] blackJack(int bruteNum, int[] list) {
		int[] allSum = new int[bruteNum];
		int count = 0;
		for (int i = 0; i < list.length - 2; i++) {
			for (int j = i + 1; j < list.length - 1; j++)
				for (int k = j + 1; k < list.length; k++) {
					allSum[count] = list[i] + list[j] + list[k];
					count++;
				}
		}
		return allSum;
	}

	public static void findMaxValue(int[] allSum, int maxValue) {
		int max = -1;
		for (int i = 0; i < allSum.length; i++) {
			if (allSum[i] <= maxValue && allSum[i] > max)
				max = allSum[i];
		}
		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int maxValue = Integer.parseInt(st.nextToken());

		int bruteNum = (N * (N - 1) * (N - 2)) / 6;
		int[] list = new int[N];
		int[] allSum = new int[N];
		st = new StringTokenizer(br.readLine());
		br.close();
		for (int i = 0; i < N; i++)
			list[i] = Integer.parseInt(st.nextToken());
		allSum = Problem2798.blackJack(bruteNum, list);
		Problem2798.findMaxValue(allSum, maxValue);

	}

}
