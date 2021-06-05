package cp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1261 {
	static int[][] maze;
	static Integer[][] visited;

	private static void solution(int N, int M) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(0);
		q.add(0);
		visited[0][0] = 0;

		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();

			if (x - 1 >= 0) {
				if (visited[x - 1][y] == null) {
					q.add(x - 1);
					q.add(y);

					if (maze[x - 1][y] == 1)
						visited[x - 1][y] = visited[x][y] + 1;
					else if (maze[x - 1][y] == 0)
						visited[x - 1][y] = visited[x][y];
				} else {
					if (maze[x - 1][y] == 1 && visited[x][y] + 1 < visited[x - 1][y]) {
						q.add(x - 1);
						q.add(y);
						visited[x - 1][y] = visited[x][y] + 1;
					} else if (maze[x - 1][y] == 0 && visited[x][y] < visited[x - 1][y]) {
						q.add(x - 1);
						q.add(y);
						visited[x - 1][y] = visited[x][y];
					}
				}
			}

			if (x + 1 < N) {
				if (visited[x + 1][y] == null) {
					q.add(x + 1);
					q.add(y);

					if (maze[x + 1][y] == 1)
						visited[x + 1][y] = visited[x][y] + 1;
					else if (maze[x + 1][y] == 0)
						visited[x + 1][y] = visited[x][y];
				} else {
					if (maze[x + 1][y] == 1 && visited[x][y] + 1 < visited[x + 1][y]) {
						q.add(x + 1);
						q.add(y);
						visited[x + 1][y] = visited[x][y] + 1;
					}

					else if (maze[x + 1][y] == 0 && visited[x][y] < visited[x + 1][y]) {
						q.add(x + 1);
						q.add(y);
						visited[x + 1][y] = visited[x][y];
					}
				}
			}

			if (y - 1 >= 0) {
				if (visited[x][y - 1] == null) {
					q.add(x);
					q.add(y - 1);

					if (maze[x][y - 1] == 1)
						visited[x][y - 1] = visited[x][y] + 1;
					else if (maze[x][y - 1] == 0)
						visited[x][y - 1] = visited[x][y];
				} else {
					if (maze[x][y - 1] == 1 && visited[x][y] + 1 < visited[x][y - 1]) {
						q.add(x);
						q.add(y - 1);
						visited[x][y - 1] = visited[x][y] + 1;
					} else if (maze[x][y - 1] == 0 && visited[x][y] < visited[x][y - 1]) {
						q.add(x);
						q.add(y - 1);
						visited[x][y - 1] = visited[x][y];
					}
				}
			}

			if (y + 1 < M) {
				if (visited[x][y + 1] == null) {
					q.add(x);
					q.add(y + 1);

					if (maze[x][y + 1] == 1)
						visited[x][y + 1] = visited[x][y] + 1;
					else if (maze[x][y + 1] == 0)
						visited[x][y + 1] = visited[x][y];

				} else {
					if (maze[x][y + 1] == 1 && visited[x][y] + 1 < visited[x][y + 1]) {
						q.add(x);
						q.add(y + 1);
						visited[x][y + 1] = visited[x][y] + 1;
					} else if (maze[x][y + 1] == 0 && visited[x][y] < visited[x][y + 1]) {
						q.add(x);
						q.add(y + 1);
						visited[x][y + 1] = visited[x][y];
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

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new Integer[N][M];

		for (int i = 0; i < maze.length; i++) {
			StringBuffer str = new StringBuffer(br.readLine());
			for (int j = 0; j < maze[i].length; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}

		solution(N, M);
	}

}
