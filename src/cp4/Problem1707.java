package cp4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1707 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] colored;

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(start);
		visited[start] = true;
		colored[start] = 1;
		while (!q.isEmpty()) {
			int vertex = q.poll();
			for (int i = 0; i < graph[vertex].size(); i++) {
				int next = graph[vertex].get(i);
				if (!visited[next]) {
					visited[next] = true;

					if (colored[vertex] == 1) {
						colored[next] = 2;
						q.add(next);
					} else {
						colored[next] = 1;
						q.add(next);
					}

				}
			}
		}
	}

	private static String solution() {
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				bfs(i);
			}
		}

		for (int i = 1; i < graph.length; i++) {
			int color = colored[i];
			for (int j = 0; j < graph[i].size(); j++) {
				if (color == colored[graph[i].get(j)])
					return "NO";
			}
		}

		return "YES";
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			graph = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			colored = new int[V + 1];

			for (int j = 1; j < graph.length; j++) {
				graph[j] = new ArrayList<Integer>();
			}

			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph[a].add(b);
				graph[b].add(a);
			}

			bw.write(solution() + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
