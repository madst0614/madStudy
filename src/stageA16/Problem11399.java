package stageA16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11399 {
	static int[] time;

	public static int findMinTime() {
		int sum = 0;
		int total = 0;
		for (int i = 0; i < time.length; i++) {
			sum += time[i];
			total += sum;
		}
		return total;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		time = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time);

		System.out.println(findMinTime());
	}

}
