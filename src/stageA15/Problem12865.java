package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12865 {
	static int MAXWEIGHT;
	static int[][] V;
	static int[][] stuff;

	private static int findMax(int i, int w) {
		int include = V[i - 1][w - stuff[i][0]] + stuff[i][1];
		int exclude = V[i - 1][w];
		if (exclude < include)
			return include;
		else
			return exclude;
	}

	private static int packingBackPack() {
		for (int i = 1; i < V.length; i++)
			for (int w = 1; w < V[i].length; w++) {
				if (w < stuff[i][0])
					V[i][w] = V[i - 1][w];
				else
					V[i][w] = findMax(i, w);
			}

		return V[V.length - 1][V[V.length - 1].length - 1];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 물건의 개수
		int N = Integer.parseInt(st.nextToken());
		// 최대 무게
		MAXWEIGHT = Integer.parseInt(st.nextToken());

		V = new int[N + 1][MAXWEIGHT + 1];
		stuff = new int[N + 1][2];
		for (int i = 1; i < V.length; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken()); // weight
			stuff[i][1] = Integer.parseInt(st.nextToken()); // value
		}

		System.out.println(packingBackPack());
	}

}
