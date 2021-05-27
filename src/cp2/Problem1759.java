package cp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1759 {
	static char[] alph;
	static char[] passWord;

	private static boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			return true;
		else
			return false;
	}

	private static void solution(int N, int prev, int vowel, BufferedWriter bw) throws IOException {
		if (N == passWord.length) {
			if (vowel >= 1 && passWord.length - vowel >= 2) {
				for (int i = 0; i < passWord.length; i++) {
					bw.write(passWord[i]);
				}
				bw.write("\n");
			}
			return;
		}

		for (int i = prev + 1; i < alph.length; i++) {
			passWord[N] = alph[i];
			if (isVowel(alph[i]))
				solution(N + 1, i, vowel + 1, bw);
			else
				solution(N + 1, i, vowel, bw);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		alph = new char[C];
		passWord = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < alph.length; i++) {
			alph[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alph);
		solution(0, -1, 0, bw);

		br.close();
		bw.flush();
		bw.close();
	}

}
