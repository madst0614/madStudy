package stageA21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1920 {
	static int[] num;

	private static int solution(int M) {
		int start = 0;
		int end = num.length - 1;

		while (true) {
			int index = (start + end) / 2;

			if (end - start <= 2) {
				for (int i = start; i <= end; i++)
					if (num[i] == M)
						return 1;

				return 0;
			}

			if (num[index] == M)
				return 1;

			if (num[index] < M)
				start = index + 1;
			else
				end = index - 1;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		num = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(num);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++)
			bw.write(solution(Integer.parseInt(st.nextToken())) + "\n");

		br.close();
		bw.flush();
		bw.close();
	}

}
