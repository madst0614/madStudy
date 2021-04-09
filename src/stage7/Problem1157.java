package stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1157 {

	public static void initCharCount(int[] charCount) {
		for (int i = 0; i < charCount.length; i++)
			charCount[i] = 0;
	}

	public static void findMaxCount(String str, int[] charCount, boolean isDuplic) {
		int max = 0;

		// 대문자, 소문자 구분 없이 같은 행렬 인덱스로 매칭
		for (int i = 0; i < str.length(); i++) {
			int whatChar;
			if (str.charAt(i) >= 97)
				whatChar = str.charAt(i) - 'a';
			else
				whatChar = str.charAt(i) - 'A';
			charCount[whatChar]++;
		}
		// max값을 찾는 동시에 다른 문자와 같은 카운트 isDuplicate 검사
		for (int i = 0; i < charCount.length; i++) {
			if (charCount[i] > charCount[max]) {
				isDuplic = false;
				max = i;
			} else if (i != max && charCount[i] == charCount[max])
				isDuplic = true;
		}
		// isDuplicate 값에 따라 해당 알파벳과 ?(중복된 카운트를 갖는 다른 알파벳) 출력
		if (isDuplic == false) {
			max += 'A';
			System.out.println((char) max);
		} else
			System.out.println("?");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int[] charCount = new int[26];
		boolean isDuplic = false;

		Problem1157.initCharCount(charCount);
		Problem1157.findMaxCount(str, charCount, isDuplic);

	}

}
