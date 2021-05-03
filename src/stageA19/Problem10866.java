package stageA19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class DoubleLinkedNode {

	int data;
	DoubleLinkedNode lLink;
	DoubleLinkedNode rLink;

	DoubleLinkedNode(int data) {
		this.data = data;
	}

	DoubleLinkedNode(int data, DoubleLinkedNode lLink, DoubleLinkedNode rLink) {
		this.data = data;
		this.lLink = lLink;
		this.rLink = rLink;
	}
}

class LinkedDequeue {
	int length;
	DoubleLinkedNode front, rear;

	LinkedDequeue() {
		this.length = 0;
		this.front = this.rear = null;
	}

	void pushFront(int data) {

		if (length == 0) {
			DoubleLinkedNode newNode = new DoubleLinkedNode(data);
			this.front = newNode;
			this.rear = newNode;
			this.length++;
			return;
		}

		DoubleLinkedNode newNode = new DoubleLinkedNode(data);
		newNode.rLink = this.front;
		this.front.lLink = newNode;
		this.front = newNode;
		this.length++;
	}

	void pushRear(int data) {

		if (length == 0) {
			DoubleLinkedNode newNode = new DoubleLinkedNode(data);
			this.front = newNode;
			this.rear = newNode;
			this.length++;
			return;
		}

		DoubleLinkedNode newNode = new DoubleLinkedNode(data);
		newNode.lLink = this.rear;
		this.rear.rLink = newNode;
		this.rear = newNode;
		this.length++;
	}

	int popFront() {

		if (length == 0)
			return -1;

		int data = this.front.data;
		this.length--;

		if (this.front.rLink == null) {
			this.front = null;
			this.rear = null;

			return data;
		}

		this.front = this.front.rLink;
		this.front.lLink = null;

		return data;
	}

	int popRear() {

		if (length == 0)
			return -1;

		int data = this.rear.data;
		this.length--;

		if (this.rear.lLink == null) {
			this.front = null;
			this.rear = null;
			return data;
		}

		this.rear = this.rear.lLink;
		this.rear.rLink = null;

		return data;
	}

	int size() {
		return this.length;
	}

	int empty() {
		if (this.length == 0)
			return 1;
		else
			return 0;
	}

	int front() {
		if (this.length == 0)
			return -1;

		return this.front.data;
	}

	int back() {
		if (this.length == 0)
			return -1;

		return this.rear.data;
	}

}

public class Problem10866 {

	private static void dequeueIO(LinkedDequeue q, String str, BufferedWriter bw) throws IOException {
		StringTokenizer st = new StringTokenizer(str);

		switch (st.nextToken()) {
		case "push_back":
			q.pushRear(Integer.parseInt(st.nextToken()));
			break;

		case "push_front":
			q.pushFront(Integer.parseInt(st.nextToken()));
			break;

		case "pop_front":
			bw.write(q.popFront() + "\n");
			break;

		case "pop_back":
			bw.write(q.popRear() + "\n");
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
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		LinkedDequeue q = new LinkedDequeue();
		for (int i = 0; i < N; i++) {
			dequeueIO(q, br.readLine(), bw);
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
