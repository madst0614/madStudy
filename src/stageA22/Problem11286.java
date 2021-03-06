package stageA22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem11286 {
	static int[] heap;
	static int heapSize;

	private static void insert(int num) {
		int i = ++heapSize;
		int absNum = Math.abs(num);

		while (i != 1 && absNum <= Math.abs(heap[i / 2])) {
			if (absNum == Math.abs(heap[i / 2]))
				if (num > heap[i / 2])
					break;

			heap[i] = heap[i / 2];
			i /= 2;
		}

		heap[i] = num;
	}

	private static int delete() {
		if (heapSize == 0)
			return 0;

		int item = heap[1];
		int temp = heap[heapSize--];
		int absTemp = Math.abs(temp);

		int parent = 1;
		int child = 2;

		while (child <= heapSize) {
			if (child < heapSize) {
				if (Math.abs(heap[child]) > Math.abs(heap[child + 1]))
					child++;

				else if (Math.abs(heap[child]) == Math.abs(heap[child + 1])) {
					if (heap[child] > heap[child + 1])
						child++;
				}
			}

			if (absTemp < Math.abs(heap[child]))
				break;

			if (absTemp == Math.abs(heap[child]))
				if (temp < heap[child])
					break;

			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}

		heap[parent] = temp;

		return item;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		heap = new int[N + 1];
		heapSize = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0)
				bw.write(delete() + "\n");
			else
				insert(num);
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
