import java.util.Arrays;

class MergeSort {
	// Recursive implementation
	public static void mergeSortRecursive(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = start + ((end - start) / 2);
		// merge sort left
		mergeSortRecursive(a, start, mid);
		// merge sort right
		mergeSortRecursive(a, mid + 1, end);
		// merge left and right
		merge(a, start, mid, end);
	}

	// Iterative implementation
	public static void mergeSortIterative(int[] array) {
		for (int i = 1; i <= (array.length / 2) + 1; i *= 2) {
			for (int j = i; j < array.length; j += 2 * i) {
				merge(array, j - i, j - 1, Math.min(j + i - 1, array.length - 1));
			}
		}

	}

	private static void merge(int[] a, int start, int mid, int end) {
		int p = start;
		int q = mid + 1;
		int[] newArr = new int[end - start + 1];
		int i = 0;
		while (p <= mid || q <= end) {
			if (p <= mid && q <= end) {
				if (a[p] > a[q]) {
					newArr[i++] = a[q++];
				} else {
					newArr[i++] = a[p++];
				}
			} else if (p <= mid) {
				newArr[i++] = a[p++];
			} else if (q <= end) {
				newArr[i++] = a[q++];
			}
		}
		int k = start;
		for (int j = 0; j < newArr.length; j++) {
			a[k++] = newArr[j];
		}
	}

	public static void main(String args[]) {
		int[] a = { 12, 11, 13, 5, 6, 7 };
		System.out.println("Unsorted array: " + Arrays.toString(a));
		MergeSort.mergeSortRecursive(a, 0, a.length - 1);
		System.out.println("Sorted array using recursive mergesort: " + Arrays.toString(a));

		int[] b = { 12, 11, 5, 13, 7, 6 };
		System.out.println("Unsorted array: " + Arrays.toString(b));
		MergeSort.mergeSortIterative(b);
		System.out.println("Sorted array using iterative mergesort: " + Arrays.toString(b));

	}

}
