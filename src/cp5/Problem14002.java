package cp5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem14002 {
	static int[] list;
	static int[] seq;
	static int[] seqIdx;
	static int[] tracking;
	static int[] result;
	static int max = Integer.MIN_VALUE;

	private static int lowerBound(int num, int length) {
		int hi = length;
		int lo = 1;
		int mid = (hi + lo) / 2;

		while (lo < hi) {
			if (num < seq[mid])
				hi = mid;
			else
				lo = mid + 1;

			mid = (hi + lo) / 2;
		}

		return hi;
	}

	private static void solution(int N) {
		int length = 1;

		for (int i = 0; i < list.length; i++) {
			int idx = lowerBound(list[i], length);
			if (list[i] == seq[idx - 1]) {
				continue;
			}

			if (seq[idx] == 0)
				length++;

			if (idx > max)
				max = idx;

			seq[idx] = list[i];
			seqIdx[idx] = i;
			tracking[i] = seqIdx[idx - 1];

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		list = new int[N];
		seq = new int[N + 1];
		seqIdx = new int[N + 1];
		tracking = new int[N];
		result = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		solution(N);

		int link = seqIdx[max];
		for (int i = max - 1; i >= 0; i--) {
			result[i] = list[link];
			link = tracking[link];
		}

		bw.write(max + "\n");
		for (int i = 0; i < max; i++) {
			bw.write(result[i] + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
