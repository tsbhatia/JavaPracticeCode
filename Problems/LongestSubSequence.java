import java.util.Arrays;
/*
Compute the longest contiguous increasing subarray
O(n)
*/
class LongestSubSequence{ 

 public static int[] getLongestSubSequence(int[] arr){
   int max = 1;
   int maxNew = 1;
   int r1 = 0;
   for(int i=1; i< arr.length;i++){
    if(arr[i-1] < arr[i]){
     maxNew++;
    }else {
     if(maxNew > max){
      max = maxNew;
      r1 = i-1;
     }
     maxNew = 1;
    }
   }
   int[] output = new int[max];
   int j = 0;
   System.out.println("max length: "+ max);
   for(int i=r1-max+1; i<=r1;i++){
    output[j++]= arr[i]; 
   } 
   return output;
 }

 public static void main(String args[]){
  int[] arr = {2,11,3,5,5,-13,7,19,20,21,17,23};
  System.out.println("Given array: " + Arrays.toString(arr));
  int[] output = LongestSubSequence.getLongestSubSequence(arr);
  System.out.println("Long sub-sequence: " + Arrays.toString(output));
  
 }
}
