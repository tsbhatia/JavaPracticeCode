import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class LongestKStrings{
 
 public static void getLongestStrings(int k, Iterator<String> itr){
  PriorityQueue<String> pq = new PriorityQueue<>(k, new Comparator<String>()
   {
    public int compare(String s1, String s2){
     return Integer.compare(s1.length(), s2.length());
    }
   }
  );
  
  while(itr.hasNext()){
   if(pq.size() < k){
    String next = itr.next();
    System.out.println("Saving string: " + next);
    pq.add(next);
   }else{
    String next = itr.next();
    if(pq.peek().length() < next.length()){
     System.out.println("\n Removing string: "+ pq.poll());
     pq.add(next);
     System.out.println("Adding string: " + next);
    }
   } 
  }
  
  System.out.println("\n Remaining elements");
  while(pq.size() > 0)
   System.out.println("\t"+ pq.poll());
 }

 public static void main(String args[]){
  List<String> input = new ArrayList<String>(Arrays.asList("I","love","you","happy","birthday","merry","chrismas"));
  LongestKStrings.getLongestStrings(3, input.iterator()); 
 }

}
