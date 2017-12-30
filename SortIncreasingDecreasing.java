import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
This class sort the list which has increasing 
and decreasing elements. E.g.
 {50,60,70,40,39,38,51,52,53,20,19,18};
first 3 elements are increasing, next
3 elements are decreasing,next 3
elements are increasing and so on. 

We can first sepearted out all the sorted arrays.
reverse the arrays which are decreasing. 
then Merge Sort all these array using MergeSortFiles class.
*/
class SortIncreasingDecreasing{
 private enum SortOrder{ 
   INCREASING, DECREASING;
 }
 public List<Integer> sortIncreasingDecreasingArray(int[] array){
  SortOrder order = SortOrder.INCREASING;
  
  List<List<Integer>> sepArray = new ArrayList<>();
  int start = 0, end = 0;
  for(int i=1;i<array.length;i++){
   if((array[i-1] < array[i] && order == SortOrder.DECREASING)
       || (array[i-1] >= array[i] && order == SortOrder.INCREASING)){
     order = order == SortOrder.INCREASING? SortOrder.DECREASING:SortOrder.INCREASING;
     end = i;
   }
   if(i == array.length -1){
    end = i+1;
    order = order == SortOrder.INCREASING? SortOrder.DECREASING:SortOrder.INCREASING;
   }
   if(end != 0 && start != end){
     List<Integer> sublist = getList(array, start, end);
     if(order == SortOrder.INCREASING){
      Collections.reverse(sublist);
     }
     sepArray.add(sublist);
     System.out.println("sep array so far: "+ sepArray);
     start = end;
   }
  }
  MergeSortedFiles msf = new MergeSortedFiles();
  return msf.mergeSortedFiles(sepArray);
 }

 private List<Integer> getList(int[] array, int start, int end){
  List<Integer> output = new ArrayList<>();
  for(int i=start;i<end;i++){
    output.add(array[i]);
  }
  return output;
 }

 public static void main(String args[]){
  int[] input = {50,60,70,40,39,38,51,52,53,20,19,18};
  System.out.println("Input Increasing and decreasing array: "+ Arrays.toString(input));
  SortIncreasingDecreasing sid = new SortIncreasingDecreasing();
  List<Integer> output = sid.sortIncreasingDecreasingArray(input);
  System.out.println("Output sorted array: " + output);
 }
}
