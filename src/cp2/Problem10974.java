package cp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem10974 {
	static int[] bruteList;
	static int[] backList;
	static boolean[] num;

	private static void solution() {
		int idx = 0;
		for (int i = bruteList.length - 2; i > 0; i--) {
			if (bruteList[i] < bruteList[i + 1]) {
				idx = i;
				break;
			}
		}

		Arrays.sort(bruteList, idx + 1, bruteList.length);

		for (int i = idx + 1; i < bruteList.length; i++) {
			if (bruteList[idx] < bruteList[i]) {
				int temp = bruteList[i];
				bruteList[i] = bruteList[idx];
				bruteList[idx] = temp;
				break;
			}
		}
	}

	
	// Back-Tracking 
	private static void solution(int state, int N, BufferedWriter bw) throws IOException {
		if (state == N + 1) {
			for (int i = 1; i < backList.length; i++) {
				bw.write(backList[i] + " ");
			}

			bw.write("\n");
			return;
		}

		for (int i = 1; i < backList.length; i++) {
			if (!num[i]) {
				num[i] = true;
				backList[state] = i;
				solution(state + 1, N, bw);
				num[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		br.close();
		
		//Brute-Force - Initialization
		int trial = 1;
		bruteList = new int[N + 1];
		
		//Back-Tracking - Initialization
		backList = new int[N + 1];
		num = new boolean[N + 1];

		for (int i = N; i > 1; i--) {
			trial *= i;
		}
		
		//Brute-Force
		bw.write("\n브루트 포스\n");
		for (int i = 1; i < bruteList.length; i++) {
			bruteList[i] = i;
			bw.write(bruteList[i] + " ");
		}
		bw.write("\n");

		for (int i = 1; i < trial; i++) {
			solution();
			for (int j = 1; j < bruteList.length; j++) {
				bw.write(bruteList[j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		
		//Back-Tracking
		bw.write("\n백트래킹\n");
		solution(1, N, bw);
		bw.flush();
		bw.close();
	}

}
