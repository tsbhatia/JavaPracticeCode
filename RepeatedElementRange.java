import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Variant #4 of 11.1 (EPI in Java) Search a sorted array 
for the first occurrence of k.
Write a program which takes a sorted array A of integers
and an integer k, and returns the interval enclosing k,
i.e., the pair of integers L and U such that L is the 
first occurrence of k and U is the last occurrence of k
in A. If k does not appear in A return [-1,-1]. 
*/
class RepeatedElementRange{

 public static List<Integer> getRepeatedElementRange(int[] a, int number){
  int L = 0, U = a.length - 1;
  int right = -1, left = -1;
  // looking for upper index of number
  while(L <= U){
   int mid = L + ((U - L)/2);
   if(a[mid] < number){
    L = mid + 1;
   }else if(a[mid] == number){
    right = mid;
    L = mid + 1;
   }else {
    U = mid - 1;
   } 
  }
  //System.out.println("right side is "+right);
  // looking for lower index of number
  L = 0; U = a.length - 1;
  while(L <= U){
   int mid = L + ((U - L)/2);
   if(a[mid] < number){
    L = mid + 1;
   }else if(a[mid] == number){
    left = mid;
    U = mid - 1;
   }else {
    U = mid - 1;
   } 
  }
  //System.out.println("left side is "+left);
  return new ArrayList<Integer>(Arrays.asList(left, right)); 
 }
 public static void main(String args[]){
  int[] a = {-14,-14,-13,-10,2, 108,108,243,285,285,285,401};
  System.out.println("Input data is " + Arrays.toString(a));
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter a number to find its duplicate range in the array");
  int number = sc.nextInt();
  System.out.println("Repeated number range for given target in the list is "+ 
                         RepeatedElementRange.getRepeatedElementRange(a, number));
 }

}
