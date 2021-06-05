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

public class Problem2667 {
	static int[][] house;
	static ArrayList<Integer> dfsAnswer;
	static ArrayList<Integer> bfsAnswer;

	// 출처 : https://www.acmicpc.net/source/29547292(aeternussm님 코드)
	public static int dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= house.length || j >= house[i].length)
			return 0;
		if (house[i][j] == 0)
			return 0;

		house[i][j] = 0;
		int sum = 0;

		sum += dfs(i + 1, j);
		sum += dfs(i - 1, j);
		sum += dfs(i, j + 1);
		sum += dfs(i, j - 1);

		return 1 + sum;
	}

	// 내 코드
	private static void bfs(int i, int j) {
		Queue<Integer> q = new LinkedList<Integer>();

		int start = i * house.length + j;
		q.add(start);

		while (!q.isEmpty()) {
			int vertex = q.poll();
			int row = vertex / house.length;
			int col = vertex % house.length;
			if (house[row][col] == 0 || house[row][col] > 1)
				continue;

			house[row][col] = 0;
			house[i][j]++;

			if (0 < row) {
				if (house[row - 1][col] == 1) {
					int next = vertex - house.length;
					q.add(next);
				}
			}

			if (row + 1 < house.length) {
				if (house[row + 1][col] == 1) {
					int next = vertex + house.length;
					q.add(next);
				}
			}

			if (0 < col) {
				if (house[row][col - 1] == 1) {
					int next = vertex - 1;
					q.add(next);
				}
			}

			if (col + 1 < house.length) {
				if (house[row][col + 1] == 1) {
					int next = vertex + 1;
					q.add(next);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		house = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringBuffer sb = new StringBuffer(br.readLine());
			for (int j = 0; j < N; j++) {
				house[i][j] = sb.charAt(j) - '0';
			}
		}

		dfsAnswer = new ArrayList<Integer>();
		bfsAnswer = new ArrayList<Integer>();

//		for (int i = 0; i < house.length; i++) {
//			for (int j = 0; j < house[i].length; j++) {
//				if (house[i][j] == 1) {
//					dfsAnswer.add(dfs(i, j));
//				}
//			}
//		}

		for (int i = 0; i < house.length; i++) {
			for (int j = 0; j < house[i].length; j++) {
				if (house[i][j] == 1) {
					bfs(i, j);
					bfsAnswer.add(house[i][j]);
				}
			}
		}
//
//		bw.write("dfs\n");
//		Collections.sort(dfsAnswer);
//		bw.write(dfsAnswer.size() + "\n");
//		for (int ans : dfsAnswer) {
//			bw.write(ans + "\n");
//		}
		
		bw.write("bfs\n");
		Collections.sort(bfsAnswer);
		bw.write(bfsAnswer.size() + "\n");
		for (int ans : bfsAnswer) {
			bw.write(ans + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
