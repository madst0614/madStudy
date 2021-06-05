package cp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1697 {
	static int[] visited = new int[100_001];

	private static void solution(int N, int K) {
		if (N >= K) {
			System.out.println(N - K);
			return;
		}

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(N);

		while (!q.isEmpty()) {
			int d = q.poll();
			if (d == K) {
				System.out.println(visited[K]);
				return;
			}

			if (d - 1 > 0 && visited[d - 1] == 0) {
				q.add(d - 1);
				visited[d - 1] = visited[d] + 1;
			}

			if (d + 1 <= 100_000 && visited[d + 1] == 0) {
				q.add(d + 1);
				visited[d + 1] = visited[d] + 1;
			}

			if (d * 2 <= 100_000 && visited[d * 2] == 0) {
				q.add(d * 2);
				visited[d * 2] = visited[d] + 1;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		visited = new int[100_001];

		solution(N, K);
	}

}
