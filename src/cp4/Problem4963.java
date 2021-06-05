package cp4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem4963 {
	static int[][] map;

	private static void dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= map.length || j >= map[i].length)
			return;
		if (map[i][j] == 0)
			return;

		map[i][j] = 0;

		dfs(i - 1, j);
		dfs(i, j - 1);
		dfs(i + 1, j);
		dfs(i, j + 1);
		dfs(i - 1, j + 1);
		dfs(i + 1, j - 1);
		dfs(i + 1, j + 1);
		dfs(i - 1, j - 1);
	}

	private static int solution() {
		int count = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					dfs(i, j);
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (h == 0 && w == 0)
				break;

			map = new int[h][w];

			for (int j = 0; j < map.length; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < map[j].length; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			bw.write(solution() + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
