import java.util.*;

class MinInRotateString{

 public static int getMinValueIndex(String[] words){
   int l = 0, h = words.length - 1;

   while(l < h){
    int mid = l + (h-l)/2;
    if(words[h].compareTo(words[mid]) > 0){
      h = mid;
    }else {
      l = mid+1;
    }
   }
   return l;
 }

 public static void main(String args[]){
  String[] words = {
    "ptolemaic",
    "retrograde",
    "supplant",
    "undulate",
    "xenoepist",
    "asymptote",  // <-- rotates here!
    "babka",
    "banoffee",
    "engender",
    "karpatka",
    "othellolagkage"};

  System.out.println(Arrays.toString(words));
  System.out.println("Index of rotation: "+ getMinValueIndex(words));
 }

}
