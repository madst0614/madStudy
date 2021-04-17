package stageA14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14888 {

	static int[] num;
	static int n;

	public static StringBuffer insertSB(StringBuffer sb, char ch, int index) {
		StringBuffer newSB = new StringBuffer(sb.toString());
		newSB.setCharAt(index, ch);

		return newSB;
	}

	public static void opInsert(int value, int index, int plus, int minus, int mult, int div) {
		if (plus == 0 && minus == 0 && mult == 0 && div == 0) {
			if (num[n] < value) // 최대값
				num[n] = value;
			if (num[n + 1] > value) // 최소값
				num[n + 1] = value;

		} else {
			if (plus != 0) {
				int newValue = value + num[index];
				opInsert(newValue, index + 1, plus - 1, minus, mult, div);
			}
			if (minus != 0) {
				int newValue = value - num[index];
				opInsert(newValue, index + 1, plus, minus - 1, mult, div);
			}
			if (mult != 0) {
				int newValue = value * num[index];
				opInsert(newValue, index + 1, plus, minus, mult - 1, div);
			}
			if (div != 0) {

				int newValue = num[index];
				if (value >= 0 && newValue > 0)
					newValue = value / newValue;
				else if ((value < 0 && newValue > 0) || (value > 0 && newValue < 0))
					newValue = -(Math.abs(value) / Math.abs(newValue));
				else
					newValue = Math.abs(value) / Math.abs(newValue);

				opInsert(newValue, index + 1, plus, minus, mult, div - 1);
			}
			return;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		num = new int[n + 2];
		num[n] = Integer.MIN_VALUE; // 최대값
		num[n + 1] = Integer.MAX_VALUE; // 최소값

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mult = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());

		Problem14888.opInsert(num[0], 1, plus, minus, mult, div);

		for (int i = n; i < n + 2; i++) {
			System.out.println(num[i]);
		}
	}

}
