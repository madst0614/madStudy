package stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1316 {

	public static boolean isGroupWord(String str) {
		boolean[] isVisited = new boolean[26];
		boolean isGroupWord = true;
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 97;
			if (isVisited[index] == true && (str.charAt(i) != str.charAt(i - 1)))
				return false;
			isVisited[index] = true;
		}
		return isGroupWord;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (Problem1316.isGroupWord(str) == true)
				count++;
		}
		System.out.println(count);
	}

}
