import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class implement intersection of two sorted arrays using three different
 * approaches.
 * 
 * @author taran
 *
 */
class IntersectTwoSortedArray {

	/**
	 * Implement the intersection in O(n*m) where n is length of first array and
	 * m is length of second array. This does not take into consideration that
	 * arrays are already sorted.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Integer> intersectUsingCompare(int[] a, int[] b) {
		List<Integer> intersect = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (i == 0 || a[i] != a[i - 1]) {
				for (int j = 0; j < b.length; j++) {
					if (a[i] == b[j]) {
						intersect.add(a[i]);
						break;
					}
				}
			}
		}
		return intersect;
	}

	/**
	 * Implement the intersection in O(n*log m) where n is the number of
	 * elements in first array where as log m is time to search the elements in
	 * second array. This method take advantage of binary search because arrays
	 * are already sorted.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Integer> intersectUsingBinarySearch(int[] a, int[] b) {
		List<Integer> intersect = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (i == 0 || a[i] != a[i - 1]) {
				// binary search in one line
				// Arrays.binarySearch(b, a[i]);
				int L = 0, U = b.length - 1;
				while (L <= U) {
					int mid = L + ((U - L) / 2);
					if (b[mid] == a[i]) {
						intersect.add(a[i]);
						break;
					} else if (b[mid] < a[i]) {
						L = mid + 1;
					} else {
						U = mid - 1;
					}
				}
			}
		}
		return intersect;
	}

	/**
	 * Implement the intersection in O(n + m) time where n and m are the number
	 * of elements in array a and b respectively. Both the arrays are
	 * pre-sorted. At each iteration, if the array element differ, the smaller
	 * one can be eliminated and advance the array of smaller element. If they
	 * are equal we add that value to the intersection and advance both. We can
	 * handle the duplicate by comparing the current element with previous one.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Integer> intersectByTraversingBothArrayTogether(int[] a, int[] b) {
		List<Integer> intersect = new ArrayList<>();
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if ((a[i] == b[j]) && (i == 0 || a[i] != a[i - 1])) {
				intersect.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
		return intersect;
	}

	public static void main(String args[]) {
		int[] a = { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 };
		int[] b = { 5, 5, 6, 8, 8, 9, 10, 10 };

		System.out.println("First array: " + Arrays.toString(a));
		System.out.println("Second array: " + Arrays.toString(b));

		System.out.println("Intersect using array compare: " + intersectUsingCompare(a, b));
		System.out.println("Intersect using binary search compare: " + intersectUsingBinarySearch(a, b));
		System.out.println("Intersect using both array treversing: " + intersectByTraversingBothArrayTogether(a, b));
	}
}
