package stageA19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11866 {

	private static void initQueue(int N, Queue<Integer> q) {
		for (int i = 1; i <= N; i++)
			q.add(i);
	}

	public static void Josephus(int N, int K) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new LinkedList<Integer>();
		initQueue(N, q);

		int count = 1;

		bw.write("<");
		while (true) {
			if (q.size() == 1) {
				bw.write(q.poll() + ">");
				break;
			}

			if (count == K) {
				bw.write(q.poll() + ", ");
				count = 1;
				continue;
			}

			q.add(q.poll());
			count++;

		}
		bw.flush();
		bw.close();

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Josephus(N, K);

	}

}
