package stageA18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class ArrayStack {
	int top;
	int[] element;

	public ArrayStack(int maxNum) {
		// TODO Auto-generated constructor stub
		this.top = -1;
		this.element = new int[maxNum];
	}

	public void push(int num) {
		this.element[++this.top] = num;
	}

	public int pop() {
		if (this.top == -1)
			return -1;

		int data = this.element[this.top--];
		return data;
	}

	public int size() {
		return this.top + 1;
	}

	public int empty() {
		if (this.top == -1)
			return 1;
		else
			return 0;
	}

	public int top() {
		if (this.top == -1)
			return -1;

		return this.element[this.top];
	}

}

public class Problem10828 {
	static int maxNum = 10001;

	private static void ioInterface(String str, BufferedWriter bw, ArrayStack stack) throws IOException {
		StringTokenizer st = new StringTokenizer(str);

		String operation = st.nextToken();
		switch (operation) {

		case "push":
			stack.push(Integer.parseInt(st.nextToken()));
			break;

		case "pop":
			bw.write(stack.pop() + "\n");
			break;

		case "size":
			bw.write(stack.size() + "\n");
			break;

		case "empty":
			bw.write(stack.empty() + "\n");
			break;

		case "top":
			bw.write(stack.top() + "\n");
			break;

		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		ArrayStack stack = new ArrayStack(maxNum);

		for (int i = 0; i < N; i++) {
			ioInterface(br.readLine(), bw, stack);
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
