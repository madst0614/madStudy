package stageA12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem2108 {

	static int[] countList;

	public static void statistics() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int maxNum = 8001;
		countList = new int[maxNum];
		int medianNum = (N + 1) / 2;
		boolean foundSecond = false;
		boolean foundMedian = false;

		int mean, median = 0, mod = 0, range;

		int sum = 0;
		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		int tempModValue = -1;

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			sum += temp;

			if (temp > maxValue)
				maxValue = temp;
			if (temp < minValue)
				minValue = temp;

			countList[temp + 4000]++;

		}
		br.close();

		mean = (int) Math.round(((double) sum) / ((double) N));
		range = maxValue - minValue;

		for (int i = 0; i < countList.length; i++) {

			if (tempModValue < countList[i]) {
				tempModValue = countList[i];
				mod = i - 4000;
				foundSecond = false;
			} else if (!foundSecond && countList[i] == tempModValue) {
				mod = i - 4000;
				foundSecond = true;
			}

			if (i != 0)
				countList[i] += countList[i - 1];
			if (!foundMedian && medianNum <= countList[i]) {
				median = i - 4000;
				foundMedian = true;
			}
		}
		bw.write(mean + "\n" + median + "\n" + mod + "\n" + range + "\n");

		bw.flush();
		bw.close();
		// 입력 받을때 산술평균 최빈값 범위 모두 구함
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Problem2108.statistics();
	}

}
