package cp4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1260 {
	static ArrayList<Integer>[] graph;
	static boolean[] dfsVisited;
	static boolean[] bfsVisited;

	private static void dfs(int vertex, BufferedWriter bw) throws IOException {
		if (dfsVisited[vertex]) {
			return;
		}

		dfsVisited[vertex] = true;
		bw.write(vertex + " ");

		for (int next : graph[vertex]) {
			if (!dfsVisited[next]) {
				dfs(next, bw);
			}
		}
	}

	private static void bfs(int start, BufferedWriter bw) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(start);
		bfsVisited[start] = true;
		bw.write("\n");

		while (!q.isEmpty()) {
			int vertex = q.poll();
			bw.write(vertex + " ");

			for (int i = 0; i < graph[vertex].size(); i++) {
				int next = graph[vertex].get(i);
				if (!bfsVisited[next]) {
					q.add(next);
					bfsVisited[next] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		dfsVisited = new boolean[N + 1];
		bfsVisited = new boolean[N + 1];

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

		for (int i = 1; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}

		dfs(V, bw);
		bfs(V, bw);

		br.close();
		bw.flush();
		bw.close();
	}

}
