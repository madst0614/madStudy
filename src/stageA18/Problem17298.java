package stageA18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem17298 {
	static int[] num;
	static int[] NGE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		num = new int[N];
		NGE = new int[N];
		Arrays.fill(NGE, -1);
		Stack<Integer> s = new Stack<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (i != 0)
				if (num[i - 1] < num[i]) {
					NGE[i - 1] = num[i];
					while (true) {
						if (s.isEmpty())
							break;
						if (num[s.peek()] < num[i])
							NGE[s.pop()] = num[i];

						else
							break;
					}
				} else
					s.push(i - 1);

		}

		for (int arr : NGE) {
			bw.write(arr + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
