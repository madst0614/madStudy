package cp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem2309 {
	static int[] height;

	private static void getHeight(int sum, int answer) {
		for (int i = 0; i < height.length; i++) {
			int tempSum = sum - height[i];

			for (int j = i + 1; j < height.length; j++) {
				tempSum -= height[j];
				if (tempSum == answer) {
					height[i] = 0;
					height[j] = 0;
					return;
				}

				tempSum += height[j];
			}

		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = 9;
		height = new int[N];

		int sum = 0;
		int answer = 100;

		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}

		getHeight(sum, answer);
		Arrays.sort(height);
		for (int i = 0; i < height.length; i++) {
			if (height[i] != 0)
				bw.write(height[i] + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
