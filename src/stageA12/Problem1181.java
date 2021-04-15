package stageA12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class WordComparator implements Comparator<StringBuffer> {

	@Override
	public int compare(StringBuffer sb1, StringBuffer sb2) {
		if (sb1.length() > sb2.length())
			return 1;
		else if (sb1.length() == sb2.length()) {
			for (int i = 0; i < sb1.length(); i++) {
				if (sb1.charAt(i) > sb2.charAt(i))
					return 1;
				else if (sb1.charAt(i) == sb2.charAt(i))
					continue;
				else
					return -1;
			}
		}
		return -1;
	}
}

public class Problem1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		WordComparator wc = new WordComparator();
		int N = Integer.parseInt(br.readLine());
		StringBuffer[] word = new StringBuffer[N];

		for (int i = 0; i < N; i++) {
			word[i] = new StringBuffer(br.readLine());
		}
		br.close();

		Arrays.sort(word, wc);
		for (int i = 0; i < N; i++) {
			if (i != 0 && word[i].toString().equals(word[i - 1].toString()))
				continue;
			bw.write(word[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

}
