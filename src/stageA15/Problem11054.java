package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11054 {
	static int[] seq;
	// 0 = ascend, 1=descend
	static int[][] bitonic;

	public static int findMax(int ascend, int descend) {
		if (ascend > descend)
			return ascend;
		else
			return descend;
	}

	public static void findBitonic(int j) {
		// j가 bitonic 배열의 마지막라면
		if (j == bitonic.length - 1) {
			bitonic[j][0] = 1;
			bitonic[j][1] = 1;

		} else {

			if (seq[j] < seq[j + 1]) {
				bitonic[j][0] = findMax(bitonic[j + 1][0], bitonic[j + 1][1]) + 1;
				bitonic[j][1] = 1;
			}
			if (seq[j] > seq[j + 1]) {
				bitonic[j][0] = 1;
				bitonic[j][1] = bitonic[j + 1][1] + 1;
			}
			if (seq[j] == seq[j + 1]) {
				bitonic[j][0] = bitonic[j + 1][0];
				bitonic[j][1] = bitonic[j + 1][1];
			}

		}
	}

	public static int findMaxBitonicSeq(int N) {
		int maxBitonic = 0;
		if (N == 1)
			return 1;

		for (int i = N - 2; i >= 0; i--) {
			for (int j = N - 1; j > i; j--) {
				if (bitonic[j][0] == 0 && bitonic[j][1] == 0) {
					findBitonic(j);
				}

				if (seq[i] < seq[j]) {
					// max(ascend 경우, descend경우) - descend의 경우는 bitonic이 된다.
					int tempMax = findMax(bitonic[j][0], bitonic[j][1]);
					if (bitonic[i][0] < tempMax) {
						bitonic[i][0] = tempMax;
					}

				}

				else if (seq[i] > seq[j])
					// descend만 가능
					if (bitonic[i][1] < bitonic[j][1])
						bitonic[i][1] = bitonic[j][1];

			}
			// 자기 자신 추가
			bitonic[i][0]++;
			bitonic[i][1]++;

			if (maxBitonic < bitonic[i][0])
				maxBitonic = bitonic[i][0];
			if (maxBitonic < bitonic[i][1])
				maxBitonic = bitonic[i][1];
		}
		return maxBitonic;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		seq = new int[N];
		bitonic = new int[N][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(findMaxBitonicSeq(N));
	}
}
