package stageA19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2164 {

	private static void initQueue(int N, Queue<Integer> q) {
		for (int i = 1; i <= N; i++)
			q.add(i);
	}

	private static int solution(int N) {
		int answer = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		initQueue(N, q);
		
		while (true) {

			if (q.size() == 1) {
				answer = q.poll();
				break;
			}

			if (q.size() == 2) {
				q.poll();
				answer = q.poll();
				break;
			}

			q.poll();
			q.add(q.poll());

		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		br.close();

		System.out.println(solution(N));
	}

}
