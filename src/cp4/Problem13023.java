package cp4;
// 출처 : https://hyeonseong.tistory.com/45

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem13023 {
	static ArrayList<Integer>[] people;
	static boolean[] friend;

	private static void solution(int N, int state) {
		if (N == 5) {
			System.out.println(1);
			System.exit(0);
		}

		friend[state] = true;
		for (int i = 0; i < people[state].size(); i++) {
			int next = people[state].get(i);
			if (!friend[next]) {
				solution(N + 1, next);
			}
		}
		friend[state] = false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		people = new ArrayList[N];
		friend = new boolean[N];

		for (int i = 0; i < N; i++) {
			people[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			people[a].add(b);
			people[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			solution(1, i);
		}
		System.out.println(0);
	}

}
