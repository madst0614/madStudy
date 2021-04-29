package stageA17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem9375 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int answer = 1;
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String wearType = new String(st.nextToken());
				map.put(wearType, map.getOrDefault(wearType, 0) + 1);
			}

			for (String key : map.keySet()) {
				answer *= map.get(key) + 1;
			}
			bw.write(answer - 1 + "\n");

		}
		br.close();
		bw.flush();
		bw.close();

	}

}
