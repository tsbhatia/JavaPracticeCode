import java.util.Arrays;

class HeapSort{
 public static void sortRecursive(int[] arr){
  int len = arr.length;
  for(int i=(len/2)-1;i>=0;i--)
    heapify(arr, len, i);
  
  for(int i=len-1;i>=0;i--){
    int temp = arr[i];
    arr[i] = arr[0];
    arr[0] = temp;

    heapify(arr, i, 0);
  }
 }

 private static void heapify(int[] arr, int n, int rootIndex){
    int largest = rootIndex; // Initializing root element as a largest
    int left = 2*rootIndex + 1; // left element index in a heap
    int right = 2*rootIndex + 2; // right element index in a heap

    if(left < n && arr[left] > arr[largest]){
      largest = left;
    }
 
    if(right < n && arr[right] > arr[largest]){
      largest = right;
    }

    if(largest != rootIndex){
      int temp = arr[rootIndex];
      arr[rootIndex] = arr[largest];
      arr[largest] = temp;
      // recursively heapify the rest of the tree 
      heapify(arr, n, largest);
    }
 }

 public static void main(String args[]){
  int[] arr = {10,80,20,70,30,60,40,50,10};
  System.out.println("Unsorted array: "+ Arrays.toString(arr));
  HeapSort.sortRecursive(arr);
  System.out.println("Sorted array using recursive heap sort: "+ Arrays.toString(arr));
  
 }
}
