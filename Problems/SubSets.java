import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:
  
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]  

*/

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
class SubSets{
 
 public static List<List<Integer>> getSubsets(int[] arr){
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  generateSubsets(arr, result, new ArrayList<Integer>(), arr.length, 0); 
  return result; 
 }

 // Does not handle duplicate
 public static void generateSubsets(int[] arr, List<List<Integer>> result, List<Integer> newList, int size, int start){
   //System.out.println("new List items: "+ newList);
   result.add(new ArrayList<Integer>(newList));
   for(int i=start;i<size;i++){
     newList.add(arr[i]);
     System.out.println("Item added in new list: "+ newList);
     generateSubsets(arr, result, newList, size, i+1);
     newList.remove(newList.size()-1);
     System.out.println("Item removed in new List: "+ newList);
   }

 }
 
 public static List<List<Integer>> getSubsetsNoDuplicates(int[] arr){
  Arrays.sort(arr);
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  generateSubsetsIgnoreDuplicate(arr, result, new ArrayList<Integer>(), arr.length, 0); 
  return result; 
 }
 // remove duplicate subsets.
 public static void generateSubsetsIgnoreDuplicate(int[] arr, List<List<Integer>> result, List<Integer> newList, int size, int start){
   //System.out.println("new List items: "+ newList);
   result.add(new ArrayList<Integer>(newList));
   for(int i=start;i<size;i++){
     if(i > start && arr[i] == arr[i-1]) continue;
     newList.add(arr[i]);
     System.out.println("Item added in new list: "+ newList);
     generateSubsetsIgnoreDuplicate(arr, result, newList, size, i+1);
     newList.remove(newList.size()-1);
     System.out.println("Item removed in new List: "+ newList);
   }

 }

 public static void main(String args[]){
  int[] arr = {2,1,2};
  System.out.println("Input String: "+ Arrays.toString(arr));
  System.out.println("All subset of input: ");
  System.out.println(getSubsets(arr));
  
  System.out.println("Input String: "+ Arrays.toString(arr));
  System.out.println("All unqiue subset of input: ");
  System.out.println(getSubsetsNoDuplicates(arr));
 }
}
