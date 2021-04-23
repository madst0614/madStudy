package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11053 {

	static int[] sequence;
	static int[] maxSeq;
	static int maxIndex = 0;

	public static void findMaxSequence(int start) {

		if (start == sequence.length - 1) {
			maxSeq[start] = 1;
			return;
		}

		else {

			for (int i = start + 1; i < sequence.length; i++) {
				if (maxSeq[i] == 0)
					findMaxSequence(i);

				if (sequence[start] < sequence[i])
					if (maxSeq[start] < maxSeq[i])
						maxSeq[start] = maxSeq[i];

			}
			maxSeq[start]++;
			if (maxSeq[maxIndex] < maxSeq[start])
				maxIndex = start;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		sequence = new int[N];
		maxSeq = new int[N];

		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		findMaxSequence(0);
		System.out.println(maxSeq[maxIndex]);
	}

}
