package cp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11722 {
	static int[] list;
	static int[] seq;

	private static int solution(int N) {
		int max = seq[0];

		for (int i = 1; i < list.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (list[i] < list[j]) {
					if (seq[j] > 0 && seq[j] > seq[i]) {
						seq[i] = seq[j];
					}
				}

			}

			seq[i]++;
			if (seq[i] > max)
				max = seq[i];
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		list = new int[N];
		seq = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		seq[0] = 1;
		System.out.print(solution(N));
		br.close();
	}

}
