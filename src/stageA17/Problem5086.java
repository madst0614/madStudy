package stageA17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem5086 {

	private static boolean factorNot(int A, int B) {
		if (A <= B)
			return true;
		else {
			int temp = B;
			B = A;
			A = temp;
			return false;
		}

	}

	private static void Answer() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == 0 && B == 0)
				break;
			else {
				boolean isFactor = factorNot(A, B);
				if (isFactor && B % A == 0)
					bw.write("factor\n");
				else if (!isFactor && A % B == 0)
					bw.write("multiple\n");
				else
					bw.write("neither\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Answer();
	}

}
