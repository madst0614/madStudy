package cp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11724 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int vertex = q.poll();

			for (int i = 0; i < graph[vertex].size(); i++) {
				int next = graph[vertex].get(i);
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}

	private static int solution() {
		int count = 0;
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				bfs(i);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}
		br.close();

		System.out.println(solution());

	}

}
