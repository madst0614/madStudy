package cp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13549 {
	static Integer[] road;

	private static void solution(int N, int K) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(N);
		q.add(0);
		road[N] = 0;

		while (!q.isEmpty()) {
			int r = q.poll();
			int t = q.poll();

			if (r - 1 >= 0 && (road[r - 1] == null || t + 1 < road[r - 1])) {
				q.add(r - 1);
				q.add(t + 1);
				road[r - 1] = t + 1;

			}

			if (r + 1 < road.length && (road[r + 1] == null || t + 1 < road[r + 1])) {
				q.add(r + 1);
				q.add(t + 1);
				road[r + 1] = t + 1;
			}

			if (r * 2 < road.length && (road[r * 2] == null || t < road[r * 2])) {
				q.add(r * 2);
				q.add(t);
				road[r * 2] = t;
			}
		}

		System.out.println(road[K]);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		road = new Integer[100_001];

		solution(N, K);
	}

}
