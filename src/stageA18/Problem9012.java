package stageA18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem9012 {

	private static String checkVPS(String sb) {
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < sb.length(); i++) {
			char temp = sb.charAt(i);
			if (temp == '(')
				s.push('(');

			if (temp == ')') {
				if (s.isEmpty())
					return "NO";
				s.pop();
			}
		}
		if (s.isEmpty())
			return "YES";
		else
			return "NO";
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			bw.write(checkVPS(br.readLine()) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
