package cp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1476 {

	private static int solution(int E, int S, int M) {
		int year = 1;
		int earth = 16;
		int sun = 29;
		int moon = 20;

		int eCount = 0;
		int sCount = 0;
		int mCount = 0;

		for (; year < Integer.MAX_VALUE; year++) {
			int remE = (year + eCount) % earth;
			if (remE == 0) {
				remE = 1;
				eCount++;
			}

			int remS = (year + sCount) % sun;
			if (remS == 0) {
				remS = 1;
				sCount++;
			}

			int remM = (year + mCount) % moon;
			if (remM == 0) {
				remM = 1;
				mCount++;
			}

			if (remE == E && remS == S && remM == M) {
				return year;
			}
		}

		return year;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		System.out.println(solution(E, S, M));
	}

}
