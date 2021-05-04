package stageA19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem5430 {

	static void solution(StringBuffer sb, LinkedList<Integer> deque, BufferedWriter bw) throws IOException {
		boolean reverse = false;

		for (int i = 0; i < sb.length(); i++) {
			switch (sb.charAt(i)) {
			case 'R':
				reverse = !reverse;
				break;
			case 'D':
				if (deque.isEmpty()) {
					bw.write("error\n");
					return;
				}
				if (reverse)
					deque.pollLast();
				else
					deque.pollFirst();
			}

		}

		bw.write("[");
		while (true) {
			if (deque.isEmpty()) {
				bw.write("]\n");
				break;
			}
			if (deque.size() == 1) {
				bw.write(deque.pollFirst() + "]\n");
				break;
			}
			if (!reverse)
				bw.write(deque.pollFirst() + ",");
			else
				bw.write(deque.pollLast() + ",");
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringBuffer sb = new StringBuffer(br.readLine());
			int N = Integer.parseInt(br.readLine());

			LinkedList<Integer> deque = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine(), "[,]", false);
			for (int j = 0; j < N; j++) {
				deque.offerLast(Integer.parseInt(st.nextToken()));
			}
			solution(sb, deque, bw);
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
