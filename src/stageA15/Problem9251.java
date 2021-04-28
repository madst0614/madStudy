package stageA15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9251 {
	static int[][] lcs;
	static StringBuffer sb1;
	static StringBuffer sb2;

	private static int findMax(int i, int j) {
		if (lcs[i][j - 1] < lcs[i - 1][j])
			return lcs[i - 1][j];
		else
			return lcs[i][j - 1];
	}

	public static int lCS(StringBuffer sb1, StringBuffer sb2) {
		for (int i = 1; i < sb1.length(); i++) {
			for (int j = 1; j < sb2.length(); j++) {
				if (sb1.charAt(i) == sb2.charAt(j))
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				else
					lcs[i][j] = findMax(i, j);

			}
		}
		return lcs[sb1.length() - 1][sb2.length() - 1];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb1 = new StringBuffer(br.readLine());
		sb2 = new StringBuffer(br.readLine());

		sb1.insert(0, " ");
		sb2.insert(0, " ");
		lcs = new int[sb1.length() + 1][sb2.length() + 1];

		System.out.println(lCS(sb1, sb2));
	}

}
