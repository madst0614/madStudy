package cp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2206 {
	static int[][] maze;
	static int[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void solution(int N, int M) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		q.add(0);
		q.add(1);
		q.add(1);
		visited[0][0] = -1;

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			int t = q.poll();
			int b = q.poll();

			if (x == N - 1 && y == M - 1) {
				visited[N - 1][M - 1] = t;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (visited[nx][ny] >= b)
					continue;

				if (maze[nx][ny] == 0) {
					visited[nx][ny] = b;
					q.add(nx);
					q.add(ny);
					q.add(t + 1);
					q.add(b);

				} else {
					if (b == 1) {
						visited[nx][ny] = 0;
						q.add(nx);
						q.add(ny);
						q.add(t + 1);
						q.add(0);

					}
				}
			}
		}

		System.out.println(visited[N - 1][M - 1]);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < maze.length; i++) {
			StringBuffer str = new StringBuffer(br.readLine());
			Arrays.fill(visited[i], -1);

			for (int j = 0; j < maze[i].length; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}

		solution(N, M);
	}

}
