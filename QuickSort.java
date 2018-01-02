import java.util.Arrays;

class QuickSort {

	public static void sortRecursive(int[] arr, int l, int h) {
		if (l <= h) {
			int p = partition(arr, l, h);
			sortRecursive(arr, l, p - 1);
			sortRecursive(arr, p + 1, h);
		}
	}
        // Iteratively it can be implemented using stack, put values
        // that needs sorting into the stack.
        public static void sortIterative(int[] arr, int l, int h){
          int stack[] = new int[h-l+1];
          // stack pointer
          int top = -1;

          // initialize stack
          stack[++top] = l;
          stack[++top] = h;
       
          while(top >= 0){
             h = stack[top--];
             l = stack[top--];

             int p = partition(arr,l,h);

             if(p-1 > l){
              stack[++top] = l;
              stack[++top] = p-1;
             }
             if(p+1< h){
              stack[++top] = p+1;
              stack[++top] = h;
             }
          }
        }


	private static int partition(int[] arr, int l, int h) {
		int i = l - 1;
		int pivot = arr[h];
		for (int j = l; j <= h - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, h);
		return i + 1;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String args[]) {
		int[] arr = { 80, 70, 60, 50, 40, 30, 20, 10 };
		System.out.println("Unsorted array: " + Arrays.toString(arr));
		QuickSort.sortRecursive(arr, 0, arr.length - 1);
		System.out.println("Sorted array using recursive method: " + Arrays.toString(arr));

		int[] arr1 = { 10, 70, 20, 50, 30, 30, 20, 10 };
		System.out.println("Unsorted array: " + Arrays.toString(arr1));
		QuickSort.sortIterative(arr1, 0, arr1.length - 1);
		System.out.println("Sorted array using iterative method: " + Arrays.toString(arr1));
	}
}
