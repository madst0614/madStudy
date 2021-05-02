package stageA18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem4949 {

	private static void balance() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringBuffer str = new StringBuffer(br.readLine());
			if (str.length() == 1 && str.charAt(0) == '.')
				break;

			Stack<Character> s = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[')
					s.push(str.charAt(i));

				if (str.charAt(i) == ')')
					if (s.isEmpty() || s.pop() != '(') {
						bw.write("no\n");
						break;
					}

				if (str.charAt(i) == ']')
					if (s.isEmpty() || s.pop() != '[') {
						bw.write("no\n");
						break;
					}
				if (i == str.length() - 1) {
					if (!s.isEmpty()) {
						bw.write("no\n");
						break;
					}
					bw.write("yes\n");
				}
			}
		}
		br.close();
		bw.flush();
		bw.close();

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		balance();
	}

}
