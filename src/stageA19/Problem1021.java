package stageA19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1021 {
	static int[] numList;

	static class DoubleLinkedNode {

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

	static class LinkedDequeue {
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

		boolean empty() {
			if (this.length == 0)
				return true;
			else
				return false;
		}

		void moveLeft() {
			this.pushRear(this.popFront());
		}

		void moveRight() {
			this.pushFront(this.popRear());
		}

	}

	static int countMove(int num, LinkedDequeue q) {
		int count = 0;
		DoubleLinkedNode temp = q.front;
		while (true) {
			if (temp.data == num)
				break;
			count++;
			temp = temp.rLink;
		}

		return count;
	}

	static int solution(int N, int M) {
		int count = 0;
		LinkedDequeue q = new LinkedDequeue();
		for (int i = 1; i < N + 1; i++) {
			q.pushRear(i);
		}

		for (int i = 0; i < M; i++) {
			int countMoveLeft = countMove(numList[i], q);
			int countMoveRight = q.size() - countMoveLeft;
			// 왼쪽으로 이동이 더 적은 경우
			if (countMoveLeft < countMoveRight) {
				for (int j = 0; j < countMoveLeft; j++) {
					q.moveLeft();
					count++;
				}
			}
			// 같거나 오른쪽으로 이동이 더 적은 경우
			else {
				for (int j = 0; j < countMoveRight; j++) {
					q.moveRight();
					count++;
				}
			}
			// 해당 요소 제거
			q.popFront();
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		numList = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(N, M));
	}

}
