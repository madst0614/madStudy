package stage8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem1011 {

	public static long minOperation(long x, long y) {
		long distance = y - x;
		long minOper = 1;

		while (distance >= (minOper * minOper)) {
			minOper++;
		}
		minOper--;
		long minOperSquare = minOper * minOper;

		if ((distance - minOperSquare) == 0)
			minOper = 2 * minOper - 1;
		else if (((distance - minOperSquare) <= minOper))
			minOper = 2 * minOper;
		else
			minOper = 2 * minOper + 1;

		return minOper;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());

			bw.write(Problem1011.minOperation(x, y) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
