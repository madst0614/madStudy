package stageA12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Judge implements Comparable<Judge> {
	int age;
	StringBuffer name;

	Judge(int age, StringBuffer name) {
		this.age = age;
		this.name = name;
	}

	public int compareTo(Judge j) {
		if (this.age > j.age)
			return 1;
		else if (this.age == j.age) {
			return 0;
		} else
			return -1;
	}
}

public class Problem10814 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Judge[] people = new Judge[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people[i] = new Judge(Integer.parseInt(st.nextToken()), new StringBuffer(st.nextToken()));
		}
		br.close();

		Arrays.sort(people);
		for (int i = 0; i < N; i++) {
			bw.write(people[i].age + " " + people[i].name + "\n");
		}
		bw.flush();
		bw.close();
	}

}
