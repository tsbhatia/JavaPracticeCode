import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This Class shows the following implementation of Insertion sort
 * 
 * <pre>
 * 1) Simple insertion sort
 * 2) Binary search based insertion sort
 * 3) Insertion sort of a LinkedList
 * </pre>
 * 
 * @author taran
 *
 */
class InsertionSort {

	private static class Node {
		public int key;
		public Node next;

		public Node(int key) {
			this.key = key;
		}
	}

	static Node head;
	static Node sorted;

	public static void push(int value) {
		Node n = new Node(value);
		n.next = head;
		head = n;
	}

	public static List<Integer> print(Node node) {
		List<Integer> nodes = new ArrayList<>();
		while (node != null) {
			nodes.add(node.key);
			node = node.next;
		}
		return nodes;
	}

	/**
	 * Linked list insertion sort
	 * 
	 * @param headref
	 */
	public static void sortLinkedList(Node headref) {
		sorted = null;
		Node current = headref;
		while (current != null) {
			Node next = current.next;
			sortInsert(current);
			current = next;
		}
		head = sorted;
	}

	private static void sortInsert(Node newNode) {
		if (sorted == null || sorted.key >= newNode.key) {
			newNode.next = sorted;
			sorted = newNode;
		} else {
			Node current = sorted;
			while (current.next != null && current.next.key < newNode.key) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	/**
	 * Simple insertion sort
	 * 
	 * @param a
	 */
	public static void sortSimple(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	/**
	 * Insertion sort using binary search.
	 * 
	 * @param a
	 */
	public static void sortWithBinarySearch(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int newIndex = Math.abs(Arrays.binarySearch(a, 0, i, a[i]) + 1);
			System.arraycopy(a, newIndex, a, newIndex + 1, i - newIndex);
			a[newIndex] = key;
		}
	}

	public static void main(String args[]) {
		int[] a = { 9, 7, 6, 15, 16, 5, 10, 11 };
		System.out.println("Unsorted array: " + Arrays.toString(a));
		InsertionSort.sortSimple(a);
		System.out.println("Sorted array using simple algorithm: " + Arrays.toString(a));

		int[] b = { 9, 7, 6, 15, 16, 5, 10, 11 };
		System.out.println("Unsorted array: " + Arrays.toString(b));
		InsertionSort.sortWithBinarySearch(b);
		System.out.println("Sorted array using binary search algorithm: " + Arrays.toString(b));

		InsertionSort.push(9);
		InsertionSort.push(7);
		InsertionSort.push(6);
		InsertionSort.push(15);
		InsertionSort.push(16);
		InsertionSort.push(5);
		InsertionSort.push(10);
		InsertionSort.push(11);
		System.out.println("Unsorted array: " + InsertionSort.print(InsertionSort.head));
		InsertionSort.sortLinkedList(InsertionSort.head);
		System.out.println("Sorted array for a Linked list: " + InsertionSort.print(InsertionSort.head));

	}
}
