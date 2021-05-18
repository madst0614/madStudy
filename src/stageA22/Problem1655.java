package stageA22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1655 {
	static int[] maxHeap;
	static int[] minHeap;

	static int maxHeapSize;
	static int minHeapSize;

	private static void insertMax(int num) {
		int i = ++maxHeapSize;
		while (i != 1 && num > maxHeap[i / 2]) {
			maxHeap[i] = maxHeap[i / 2];
			i /= 2;
		}
		maxHeap[i] = num;
	}

	private static int deleteMax() {
		int item = maxHeap[1];
		int temp = maxHeap[maxHeapSize--];
		int parent = 1;
		int child = 2;

		while (child <= maxHeapSize) {
			if ((child < maxHeapSize) && (maxHeap[child] < maxHeap[child + 1]))
				child++;

			if (temp >= maxHeap[child])
				break;

			maxHeap[parent] = maxHeap[child];
			parent = child;
			child *= 2;
		}

		maxHeap[parent] = temp;

		return item;
	}

	private static void insertMin(int num) {
		int i = ++minHeapSize;

		while (i != 1 && num < minHeap[i / 2]) {
			minHeap[i] = minHeap[i / 2];
			i /= 2;
		}
		minHeap[i] = num;
	}

	private static int deleteMin() {
		if (minHeapSize == 0)
			return 0;

		int item = minHeap[1];
		int temp = minHeap[minHeapSize--];
		int parent = 1;
		int child = 2;

		while (child <= minHeapSize) {
			if (child < minHeapSize && minHeap[child] > minHeap[child + 1])
				child++;

			if (temp <= minHeap[child])
				break;

			minHeap[parent] = minHeap[child];
			parent = child;
			child *= 2;
		}
		minHeap[parent] = temp;

		return item;
	}

	private static int getMedium() {
		int sizeSum = maxHeapSize + minHeapSize;
		int mid = (sizeSum) / 2;
		if (sizeSum % 2 == 1)
			mid++;

		if (maxHeapSize < mid) {
			insertMax(deleteMin());
		}

		if (maxHeap[1] > minHeap[1]) {
			insertMin(deleteMax());
			insertMax(deleteMin());
		}

		return maxHeap[1];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		maxHeap = new int[N + 1];
		minHeap = new int[N + 1];
		maxHeapSize = 0;
		minHeapSize = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			insertMin(num);
			bw.write(getMedium() + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
