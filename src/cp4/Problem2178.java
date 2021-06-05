package cp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2178 {
	static int[][] map;

	static class Vertex {
		int i, j;
		int state;

		Vertex(int i, int j, int state) {
			this.i = i;
			this.j = j;
			this.state = state;
		}

		private boolean boundOut() {
			if (this.i < 0 || this.j < 0 || this.i >= map.length || this.j >= map[i].length)
				return true;

			return false;
		}
	}

	private static int bfsSearch(int N, int M) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(new Vertex(0, 0, 1));
		Vertex v;

		map[N - 1][M - 1] = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			v = q.poll();
			if (v.i == N - 1 && v.j == M - 1) {
				if (v.state < map[N - 1][M - 1])
					map[N - 1][M - 1] = v.state;
				continue;
			}

			if (v.boundOut() || map[v.i][v.j] == 0)
				continue;

			map[v.i][v.j] = 0;

			q.add(new Vertex(v.i - 1, v.j, v.state + 1));
			q.add(new Vertex(v.i, v.j - 1, v.state + 1));
			q.add(new Vertex(v.i + 1, v.j, v.state + 1));
			q.add(new Vertex(v.i, v.j + 1, v.state + 1));
		}

		return map[N - 1][M - 1];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			StringBuffer str = new StringBuffer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(bfsSearch(N, M));
	}

}
