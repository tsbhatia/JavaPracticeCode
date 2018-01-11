import java.util.*;
import java.util.Map.*;

class UniqueItemsSort{

 public static void main(String args[]){
  String[] words = new String[] {"Apple", "Banana", "Apple", "Grapes", "Banana", "Pears", "Banana", "Pears", "Blueberry"};

  HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
  for(int i=0;i<words.length;i++){
   String key = words[i];
   if(freqMap.containsKey(key)){
     int fq =  freqMap.get(key);
     freqMap.put(key, fq+1);
   }else{
     freqMap.put(key, 1);
   }
  }
  
  Comparator<Entry<String,Integer>> customComparator = new Comparator<Entry<String,Integer>>(){
      public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2){
        if(e1.getValue() == e2.getValue()){
          return e1.getKey().compareTo(e2.getKey());
        }else {
          return Integer.compare(e2.getValue(), e1.getValue());
      }
    }
   };

 List<Entry<String, Integer>> listEntries = new ArrayList<>(freqMap.entrySet());
  System.out.println("before sort: " + listEntries);
  Collections.sort(listEntries, customComparator);
  System.out.println("after sort: " + listEntries);

 }

}
