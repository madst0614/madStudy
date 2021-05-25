package cp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10972 {
	static int[] list;

	private static void solution(int N) {
		int idx = 0;
		for (int i = list.length - 2; i > 0; i--) {
			if (list[i] < list[i + 1]) {
				idx = i;
				break;
			}
		}

		Arrays.sort(list, idx + 1, list.length);

		for (int i = idx + 1; i < list.length; i++) {
			if (list[idx] < list[i]) {
				int temp = list[i];
				list[i] = list[idx];
				list[idx] = temp;
				break;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		list = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		solution(N);
		if (list[0] > 0)
			bw.write(-1 + " ");
		else {
			for (int i = 1; i <= N; i++)
				bw.write(list[i] + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
