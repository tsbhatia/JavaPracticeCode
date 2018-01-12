
/*
Find the first index of the substring. 
Condition: Do not use java library function or 
regular expressions. 
And measure the performance of your implementation 
with the standard java library function. 
Examples: String 1: “abcdefg” String 2: “bcd” 
should return 1 String 1: “abcdefg” String 2: “x” 
should return -1
*/
class FirstSubStringIndex{
 public static int getSubstringFirstIndex(String str, String sub){
   int len = str.length();
   int sublen = sub.length();

   for(int i=0;i<len;i++){
     int j = 0, k = i;
     while(j < sublen && k < len && str.charAt(k) == sub.charAt(j)){
        j++;k++;        
     }
     if(j == sublen){
       return i;
     }
   }
   return -1;
 }
 public static void main(String args[]){
  String string1 = "abcdefg";
  String substring1 = "cde";
  System.out.println("String: "+ string1 + ", SubString: " + substring1);
  System.out.println(getSubstringFirstIndex(string1, substring1));
  String substring2 = "x";
  System.out.println("String: "+ string1 + ", SubString: " + substring2);
  System.out.println(getSubstringFirstIndex(string1, substring2)); 
 }
}
