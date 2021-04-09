package stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1152 {

	public static int countChar(String str) {
		int howManyWord = 0;
		boolean isWord = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ' && isWord != true) { // 공백이 아니거나 단어를 읽는 상태가 아니면 howManyWord ++
				howManyWord++;
				isWord = true;
			} else if (str.charAt(i) == ' ') // 공백을 만나면 단어를 읽는 상태=false
				isWord = false;
		}
		return (howManyWord);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int howManyWord = Problem1152.countChar(str);
		System.out.println(howManyWord);

	}

}
