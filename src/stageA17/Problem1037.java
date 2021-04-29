package stageA17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1037 {
	static int[] num;

	public static int findNumber() {
		int number = 0;
		int mid = num.length / 2;
		if (num.length % 2 == 0)
			number = num[mid - 1] * num[mid];
		else
			number = num[mid] * num[mid];
		return number;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(num);
		System.out.println(findNumber());
	}

}
