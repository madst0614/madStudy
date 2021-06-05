package cp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3055 {
	static char[][] map;
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

	private static boolean nearByWater(int R, int C, int x, int y) {

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;

			if (map[nx][ny] == '*')
				return true;
		}
		return false;
	}

	private static void solution(int R, int C, Point S, Point D) {
		Queue<Point> q = new LinkedList<Point>();

		q.add(S);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '*') {
					q.add(new Point(i, j));
				}
			}
		}

		map[S.x][S.y] = '.';
		int time = 0;

		while (!q.isEmpty()) {
			Point p = q.remove();

			if (map[p.x][p.y] == '.') {
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue;

					if (nx == D.x && ny == D.y) {
						System.out.println(p.t + 1);
						return;
					}

					if (nearByWater(R, C, nx, ny))
						continue;

					if (map[nx][ny] == '.') {
						q.add(new Point(nx, ny, p.t + 1));
					}

				}
			}

			else {
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue;

					if (map[nx][ny] == '.') {
						map[nx][ny] = '*';
						q.add(new Point(nx, ny, p.t + 1));
					}

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
		map = new char[R][C];

		Point S = new Point(-1, -1);
		Point D = new Point(-1, -1);

		for (int i = 0; i < map.length; i++) {
			StringBuffer str = new StringBuffer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					S = new Point(i, j);
				}

				if (map[i][j] == 'D') {
					D = new Point(i, j);
				}
			}
		}

		solution(R, C, S, D);
	}

}
