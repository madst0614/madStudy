package stageA14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15650 {

	static int depth = 0;
	static int[] sequence;
	static boolean[] isVisited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void dFS(int N, int M) throws IOException {
		if (depth == M) {
			for (int i = 0; i < M; i++)
				bw.write(sequence[i] + " ");
			bw.write("\n");
			return;
		} else {
			for (int i = 1; i < isVisited.length; i++) {
				int prevNum;
				if (depth != 0)
					prevNum = sequence[depth - 1];
				else
					prevNum = -1;

				if (!isVisited[i] && prevNum < i) {
					sequence[depth] = i;
					isVisited[i] = true;
					depth++;

					dFS(i, M);

					isVisited[i] = false;
					depth--;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int N = Integer.parseInt(st.nextToken()) + 1;
		int M = Integer.parseInt(st.nextToken());

		sequence = new int[N];
		isVisited = new boolean[N];

		Problem15650.dFS(N, M);
		bw.flush();
		bw.close();
	}
}
