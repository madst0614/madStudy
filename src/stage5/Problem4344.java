package stage5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4344 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int totScore = 0;
			double avg=0;
			int greatStudent=0;
			
			int headCount = Integer.parseInt(st.nextToken());
			int[] scoreList = new int[headCount];
			for (int j = 0; j < headCount; j++) {
				scoreList[j] = Integer.parseInt(st.nextToken());
				totScore += scoreList[j];
			}
			avg=(double)(totScore/headCount);
			for (int j = 0; j < headCount; j++) {
				if(scoreList[j]>avg)
					greatStudent++;
			}
			System.out.printf("%.3f%%\n", (double)((double)(100*greatStudent)/(double)headCount));
		}
		br.close();
	}

}
