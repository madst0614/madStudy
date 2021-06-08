package cp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3055 {
	static Integer[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Point {
		int x;
		int y;
		int t;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.t = 0;
		}

		Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	private static void water(int R, int C) {
		Queue<Point> q = new LinkedList<Point>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != null && map[i][j] == 0)
					q.add(new Point(i, j, 0));
			}
		}

		while (!q.isEmpty()) {
			Point p = q.remove();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;

				if (map[nx][ny] == null)
					continue;

				if (map[nx][ny] == 101) {
					map[nx][ny] = map[p.x][p.y] + 1;
					q.add(new Point(nx, ny));
				}
			}
		}
	}

	private static void solution(int R, int C, Point S, Point D) {
		Queue<Point> q = new LinkedList<Point>();

		q.add(S);

		water(R, C);
		while (!q.isEmpty()) {
			Point p = q.remove();

			if (p.x == D.x && p.y == D.y) {
				System.out.println(p.t);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;

				// 'X'
				if (map[nx][ny] == null)
					continue;

				if (p.t + 1 < map[nx][ny]) {
					q.add(new Point(nx, ny, p.t + 1));
					map[nx][ny] = -1;
				}

			}
		}

		System.out.println("KAKTUS");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new Integer[R][C];

		Point S = new Point(-1, -1);
		Point D = new Point(-1, -1);

		for (int i = 0; i < map.length; i++) {
			StringBuffer str = new StringBuffer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				char c = str.charAt(j);
				if (c == 'S') {
					S = new Point(i, j, 0);
					map[i][j] = 101;
				}

				if (c == 'D') {
					D = new Point(i, j, 0);
					map[i][j] = Integer.MAX_VALUE;
				}

				if (c == '.') {
					map[i][j] = 101;
				}

				if (c == '*') {
					map[i][j] = 0;
				}
			}
		}

		solution(R, C, S, D);
	}

}
