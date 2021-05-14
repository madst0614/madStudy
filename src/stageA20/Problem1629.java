package stageA20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1629 {

	private static long solution(long A, long B, long C) {
		if (B == 1)
			return A % C;

		long subSol = solution(A, B / 2, C) % C;
		if (B % 2 == 1)
			return (((subSol * subSol) % C) * (A % C)) % C;
		else
			return (subSol * subSol) % C;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());

		System.out.println(solution(A, B, C));
	}

}
