package cp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7576 {
	static int[][] box;

	static class Vertex {
		int i, j;
		int day;

		Vertex(int i, int j, int day) {
			this.i = i;
			this.j = j;
			this.day = day;

		}

		private boolean boundOut() {
			if (this.i < 0 || this.j < 0 || this.i >= box.length || this.j >= box[i].length)
				return true;

			return false;
		}
	}

	private static int solution(int N, int M) {
		Queue<Vertex> q = new LinkedList<Vertex>();

		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				if (box[i][j] == 1) {
					q.add(new Vertex(i, j, 0));
					box[i][j] = 0;
				}
			}
		}

		Vertex v;
		int count = 0;

		while (!q.isEmpty()) {
			v = q.poll();
			if (v.boundOut() || box[v.i][v.j] != 0) {
				continue;
			}

			box[v.i][v.j] = 1;
			if (count < v.day) {
				count = v.day;
			}

			q.add(new Vertex(v.i - 1, v.j, v.day + 1));
			q.add(new Vertex(v.i, v.j - 1, v.day + 1));
			q.add(new Vertex(v.i + 1, v.j, v.day + 1));
			q.add(new Vertex(v.i, v.j + 1, v.day + 1));

		}

		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				if (box[i][j] == 0) {
					return -1;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		for (int i = 0; i < box.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < box[i].length; j++)
				box[i][j] = Integer.parseInt(st.nextToken());

		}
		System.out.println(solution(N, M));
	}

}
