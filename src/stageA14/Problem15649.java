package stageA14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem15649 {
	public static boolean[] isVisited;
	static int depth = 0;

	// isVisited 초기화
	public static void initGuestBook() {
		for (int i = 1; i < isVisited.length; i++)
			isVisited[i] = false;
	}

	// 초기 설정 - StringBuffer Default 값 : 1+ " "
	public static void dFS(int N, int M) throws IOException {

		if (depth == M) {
			return;
		} else {
			for (int i = 1; i < isVisited.length; i++) {
				if (!isVisited[i]) {
					StringBuffer sb = new StringBuffer(i + " ");
					isVisited[i] = true;
					depth++;
					dFS(i, M, sb);
					// dFS가 끝난 후 값 초기화 12345 -> 12354 가능해야하기 때문
					isVisited[i] = false;
					depth--;
				}
			}
		}

	}

	// dFS가 진행됨에 따라
	public static void dFS(int N, int M, StringBuffer sb) throws IOException {

		if (depth == M) {
			System.out.println(sb);
			return;
		} else {
			for (int i = 1; i < isVisited.length; i++) {
				if (!isVisited[i]) {
					StringBuffer ab = new StringBuffer(sb.toString() + i + " ");
					isVisited[i] = true;
					depth++;
					dFS(i, M, ab);
					// dFS가 끝난 후 값 초기화 12345 -> 12354 가능해야하기 때문
					isVisited[i] = false;
					depth--;

				}
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int N = Integer.parseInt(st.nextToken()) + 1;
		int M = Integer.parseInt(st.nextToken());

		isVisited = new boolean[N];
		Problem15649.initGuestBook();
		Problem15649.dFS(1, M);
		bw.flush();
		bw.close();
	}

}
