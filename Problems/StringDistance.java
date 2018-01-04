import java.util.Arrays;

// Given a list of strings and two string word as input.
// Find the minimum distance of two string words in the list of strings
// Ex. str = I love you very much you.
//       w1 = you
//       w2 = much
// Minimum Distance is 1 i.e. Math.abs(4-5);
class StringDistance{

 public static int minDist(String[] str, String[] words){
   int min = Integer.MAX_VALUE;
   int l1 = -1, l2 = -1;

   for(int k=0;k<str.length;k++){
    if(str[k].equals(words[0])){
     l1 = k;
    }
    if(str[k].equals(words[1])){
     l2 = k;
    }
    if(l1 != -1 && l2 != -1 && min > Math.abs(l1-l2)){
     min = Math.abs(l1-l2);
    }
   }
   return min;
 }
 public static void main(String args[]){
  String[] str = {"I", "Love", "you","very","much","you"};
  String[] list = {"you","much"};
  System.out.println("Given strings are " + Arrays.toString(str));
  System.out.println("Given words for minimum distance are " + Arrays.toString(list));
  System.out.println("Minimum distance is "+ StringDistance.minDist(str, list));
 }


}
