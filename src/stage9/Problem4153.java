package stage9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem4153 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int tmpMax = 0;
		int sqrSum = -1;

		while (true) {
			st = new StringTokenizer(br.readLine());
			tmpMax = 0;
			sqrSum = 0;

			for (int i = 0; i < 3; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmpMax <= tmp) {
					sqrSum += (tmpMax * tmpMax);
					tmpMax = tmp;
				} else
					sqrSum += (tmp * tmp);
			}
			if (sqrSum == 0 && tmpMax == 0)
				break;
			if ((tmpMax * tmpMax) == sqrSum)
				bw.write("right\n");
			else
				bw.write("wrong\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
