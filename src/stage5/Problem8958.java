package stage5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem8958 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			str = br.readLine();

			int score = 0;
			int totScore = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'X') {
					score = 0;
				} else {
					score++;
					totScore += score;
				}
			}
			bw.write(totScore + "\n");
		}

		br.close();
		bw.flush();
		bw.close();

	}

}
