package cp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1182 {
	static int[] num;
	static int S;
	static int count;

	public static void solution(int prev, int prevSum) {
		if (prev != -1 && prevSum == S) {
			count++;
		}
		for (int i = prev + 1; i < num.length; i++) {
			solution(i, prevSum + num[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		num = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		solution(-1, 0);

		System.out.println(count);
	}

}
