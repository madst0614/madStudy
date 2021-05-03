package stageA19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class LinkedNode {
	int data;
	LinkedNode link;

	public LinkedNode(int data) {
		this.data = data;
		this.link = null;
	}

	public LinkedNode(int data, LinkedNode link) {
		this.data = data;
		this.link = link;
	}
}

class LinkedQueue {
	int size;
	LinkedNode front;
	LinkedNode rear;

	public LinkedQueue() {
		this.size = 0;
		this.front = null;
		this.rear = null;
	}

	void push(int data) {
		if (this.size == 0) {
			this.front = this.rear = new LinkedNode(data);
			this.size++;
			return;
		}

		this.rear.link = new LinkedNode(data);
		this.rear = this.rear.link;
		this.size++;
	}

	int pop() {
		if (this.size == 0)
			return -1;

		int data = this.front.data;
		this.front = this.front.link;
		this.size--;

		return data;
	}

	int size() {
		return this.size;
	}

	int empty() {
		if (this.size == 0)
			return 1;
		else
			return 0;
	}

	int front() {
		if (this.size == 0)
			return -1;

		return this.front.data;
	}

	int back() {
		if (this.size == 0)
			return -1;

		return this.rear.data;
	}
}

public class Problem18258 {

	static void queueIO(String str, LinkedQueue q, BufferedWriter bw) throws IOException {
		StringTokenizer st = new StringTokenizer(str);

		switch (st.nextToken()) {
		case "push":
			q.push(Integer.parseInt(st.nextToken()));
			break;
		case "pop":
			bw.write(q.pop() + "\n");
			break;

		case "size":
			bw.write(q.size() + "\n");
			break;

		case "empty":
			bw.write(q.empty() + "\n");
			break;

		case "front":
			bw.write(q.front() + "\n");
			break;

		case "back":
			bw.write(q.back() + "\n");
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		LinkedQueue q = new LinkedQueue();
		for (int i = 0; i < N; i++) {
			queueIO(br.readLine(), q, bw);
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
