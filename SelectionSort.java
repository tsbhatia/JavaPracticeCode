import java.util.Arrays;

/**
 * Selection sort implementation
 * 
 * <pre>
 * Algorithm:
 * 1) Assign MIN to location 0
 * 2) Search minimum element in the list
 * 3) Swap with value at location MIN
 * 4) Increment MIN to point next element
 * 5) Repeat until list is sorted
 * </pre>
 * 
 * @author taran
 *
 */
class SelectionSort {
	public static void sort(int[] a) {
		int MIN = 0;
		while (MIN < a.length) {
			int newMin = MIN;
			for (int i = MIN; i < a.length; i++) {
				if (a[i] < a[newMin]) {
					newMin = i;
				}
			}
			if (MIN != newMin) {
				swap(a, MIN, newMin);
			}
			MIN++;
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String args[]) {
		int[] a = { 14, 33, 27, 10, 35, 19, 42, 44 };
		System.out.println("Unsorted array: " + Arrays.toString(a));
		SelectionSort.sort(a);
		System.out.println("Sorted array: " + Arrays.toString(a));
	}
}
