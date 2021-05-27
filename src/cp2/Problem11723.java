package cp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem11723 {
	static int S;

	private static void add(int x) {
		S |= (1 << x - 1);
	}

	private static void remove(int x) {
		S &= ~(1 << x - 1);
	}

	private static void toggle(int x) {
		int num = 1 << x - 1;
		if ((S & num) == num)
			S &= ~num;
		else
			S |= num;
	}

	private static void all() {
		for (int i = 0; i < 20; i++) {
			S |= 1 << i;
		}
	}

	private static void empty() {
		S = 0;
	}

	private static int check(int x) {
		int num = 1 << x - 1;
		if ((S & num) == num)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		S = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();

			switch (oper) {
			case "add":
				int addX = Integer.parseInt(st.nextToken());
				add(addX);
				break;

			case "remove":
				int removeX = Integer.parseInt(st.nextToken());
				remove(removeX);
				break;

			case "check":
				int checkX = Integer.parseInt(st.nextToken());
				bw.write(check(checkX) + "\n");
				break;

			case "toggle":
				int toggleX = Integer.parseInt(st.nextToken());
				toggle(toggleX);
				break;

			case "all":
				all();
				break;

			case "empty":
				empty();
				break;
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
