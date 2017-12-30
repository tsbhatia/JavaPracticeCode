import java.util.*;
import java.io.*;
import java.lang.*;

/*
This class find the least greater than given k in
the array. It uses binary search. Search stops 
when L index is greater than R.

while(L <= R)
  if (arr[mid] <= k)
     L = mid + 1;
  else 
     R = mid + 1;

return L // for least greater than k
   
*/
class LeastGreaterThan{
 
 
 public static int getLeastGreaterThan(int[] arr, int target){
  int L = 0, R = arr.length - 1;
  System.out.println("L = " + L + ", R = " + R);
  while(L <= R){
   int mid = L + ((R - L)/2);
   if(arr[mid] <= target){
    L = mid + 1;
    System.out.println("L = " + L + ", R = " + R);
   }else if(arr[mid] > target){
    R = mid - 1;
    System.out.println("L = " + L + ", R = " + R);
   }
  }
  if(L >= arr.length){
   return -1;
  }
  return L;

 }
 public static void main(String args[]){
  int[] a = {-14,-14,-13,-10,2, 108,108,243,285,285,285,401};
  System.out.println("Input data is " + Arrays.toString(a));
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter any number to find its least greater in the array");
  int number = sc.nextInt();
  System.out.println("Least Greater number for given target in the list is "+ 
                         LeastGreaterThan.getLeastGreaterThan(a, number));
 }
}
