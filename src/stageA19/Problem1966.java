package stageA19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class PrintNode {
	int index;
	int priority;
	PrintNode link;

	PrintNode(int index, int priority) {
		this.index = index;
		this.priority = priority;
		this.link = null;
	}

	PrintNode(int index, int priority, PrintNode node) {
		this.index = index;
		this.priority = priority;
		this.link = node;
	}
}

class PrintQueue {
	int length;
	PrintNode front, rear;

	PrintQueue() {
		this.length = 0;
		this.front = null;
		this.rear = null;
	}

	void push(PrintNode node) {
		if (length == 0) {
			this.front = node;
			this.rear = node;
			length++;
			return;
		}

		this.rear.link = node;
		this.rear = this.rear.link;
		length++;
	}

	void pushFrontBack(PrintNode temp) {
		this.rear.link = this.front;
		this.rear = temp;
		this.front = temp.link;
		temp.link = null;
	}

	int pop() {
		if (this.front == null)
			return -1;

		int index = this.front.index;
		if (this.front.link != null)
			this.front = this.front.link;

		return index;
	}
}

public class Problem1966 {
	public static int solution(PrintQueue q, int index) {

		int count = 1;
		PrintNode temp;

		while (true) {
			temp = q.front;
			while (true) {
				if (temp.link == null)
					break;

				if (q.front.priority < temp.link.priority) {
					q.pushFrontBack(temp);
					temp = q.front;
					continue;
				}
				temp = temp.link;

			}

			if (q.front.index == index) {
				break;
			}
			q.pop();
			count++;
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());

			PrintQueue q = new PrintQueue();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				q.push(new PrintNode(j, Integer.parseInt(st.nextToken())));
			}
			bw.write(solution(q, index) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
