import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/*
MergeSortedFiles class merge multiple sorted lists.
Method mergeSortedFiles return the combined list of 
all input sorted lists. Lets say there are k sorted 
lists. We create a min-heap of size k. First we store
first element from each list as ArrayEntity which has
array value and array Id. We go through min-heap to
extract min value and then add new element from the same
array as that of the extracted element. 
*/
class MergeSortedFiles{

 public class ArrayEntity{
  public int value;
  public int arrayId;
  public ArrayEntity(int value, int arrayId){
   this.value = value;
   this.arrayId = arrayId;
  }
 }
 
 public MergeSortedFiles(){}

 public List<Integer> mergeSortedFiles(List<List<Integer>> arrays){
  List<Integer> output = new ArrayList<>();
  PriorityQueue<ArrayEntity> minHeap = new PriorityQueue<>(arrays.size(), 
           new Comparator<ArrayEntity>(){
            public int compare(ArrayEntity a, ArrayEntity b){
             return Integer.compare(a.value,b.value);
            }
           }
  );
  List<Iterator<Integer>> seq = new ArrayList<>();
  for(List<Integer> array: arrays){
   seq.add(array.iterator());
  }
  for(int i=0; i < seq.size(); i++){
   if(seq.get(i).hasNext()){
    minHeap.add(new ArrayEntity(seq.get(i).next(), i));
   }
  }  
  while(!minHeap.isEmpty()){
   ArrayEntity minEntity = minHeap.poll();
   output.add(minEntity.value);
   if(seq.get(minEntity.arrayId).hasNext()){
     minHeap.add(new ArrayEntity(
                 seq.get(minEntity.arrayId).next(), 
                                 minEntity.arrayId));
   }
  }  
  return output;
 }
 public static void main(String args[]){
  List<Integer> l1 = Arrays.asList(1,4,6,7);
  List<Integer> l2 = Arrays.asList(1,2,5,7);
  List<Integer> l3 = Arrays.asList(0,3,8,9,10);
  
  List<List<Integer>> arrays = new ArrayList<>();
  arrays.add(l1);
  arrays.add(l2);
  arrays.add(l3);
  MergeSortedFiles msf = new MergeSortedFiles();
  List<Integer> sortedArray = msf.mergeSortedFiles(arrays);
  System.out.println("Unsorted arrays: "+ l1 + l2 + l3);
  System.out.println("Combined sorted array: " + sortedArray);
 }
}
