package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1912 {
	static int[] num;

	public static int findMaxSum() {
		int max = num[0];
		int j = 0;
		for (int i = j; i < num.length; i = j) {
			int tempSum = 0;
			for (j = i; j < num.length; j++) {
				tempSum += num[j];

				if (tempSum < num[j]) {
					break;
				}
				if (max < tempSum)
					max = tempSum;
			}
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		num = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(findMaxSum());

	}

}
