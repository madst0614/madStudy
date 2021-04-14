package stageA12;

public class Problem2751 {

	static int[] list;

	public static void merge(int left, int mid, int right) {
		
	}

	public static void mergeSort(int left, int right) {
		int mid;
		if ((left + right) % 2 == 1)
			mid = (left + right) / 2 + 1;
		else
			mid = (left + right) / 2;
		
		if (mid == right)
			return;
		
		mergeSort(left, mid);
		mergeSort(mid+1,right);
		merge(left,mid,right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
