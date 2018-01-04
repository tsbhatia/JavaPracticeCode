import java.util.Arrays;

//Print all combinations of points that can compose a given number
// You can win three kinds of basketball points, 1 point, 2 points, and 3 points. 
// Given a total score n, print out all the combination to compose n.
class ComposeGivenNumber{

 public static void printComposeNumber(int[] arr, int n, int i){
  int max = 3;
  if(n == 0){
   print(arr, i);
  }else if(n > 0){
   for(int k=1;k<=max;k++){
    arr[i] = k;
    printComposeNumber(arr, n-k, i+1);
   }
  }
 }

 private static void print(int[] arr, int i){
  for(int k = 0;k<i;k++)
   System.out.print(arr[k]+" ");
  System.out.println("");
 }
 public static void main(String args[]){
  int a = 5;
  int[] arr = new int[a];
  System.out.println("Print all combination of 1, 2 and 3 for number: "+a);
  ComposeGivenNumber.printComposeNumber(arr, a, 0);
 } 
}
