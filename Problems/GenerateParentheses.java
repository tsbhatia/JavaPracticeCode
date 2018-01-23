import java.util.List;
import java.util.ArrayList;
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
class GenerateParentheses{

 public static List<String> generated(int n){
  List<String> strings = new ArrayList<String>();
  generate(strings, "", 0, 0, n);
  return strings;
 }

 public static void generate(List<String> strings, String str, int open, int close, int max){
  System.out.println(str);
  if(str.length() == max*2){
    strings.add(str);
    return;
  }

  if(open < max){
   generate(strings, str+'(',open+1,close, max);
  }

  if(close < open){
   generate(strings, str+')', open, close+1, max);
  }
 }

 public static void main(String args[]){
   System.out.println("Valid Parentheses for size 3: ");
   System.out.println(generated(3));  
 }

}
