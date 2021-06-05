package cp4;

// 출처 : https://choseongho93.tistory.com/158
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem14226 {
	static Integer[][] emti;

	private static void solution(int S) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(1);
		q.add(0);
		emti[1][0] = 0;

		while (!q.isEmpty()) {
			int s = q.poll();
			int c = q.poll();

			if (emti[s][s] == null) {
				emti[s][s] = emti[s][c] + 1;
				q.add(s);
				q.add(s);
			}

			if (s + c <= S && emti[s + c][c] == null) {
				emti[s + c][c] = emti[s][c] + 1;
				q.add(s + c);
				q.add(c);
			}

			if (s - 1 >= 0 && emti[s - 1][c] == null) {
				emti[s - 1][c] = emti[s][c] + 1;
				q.add(s - 1);
				q.add(c);
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < emti.length; i++) {
			if (emti[S][i] != null)
				if (emti[S][i] < ans)
					ans = emti[S][i];

		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int S = sc.nextInt();
		emti = new Integer[S + 1][S + 1];
		sc.close();

		solution(S);

	}

}
