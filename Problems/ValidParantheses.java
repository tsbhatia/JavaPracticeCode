import java.util.*;

class ValidParantheses{
 
 public static boolean[] validParantheses(String[] str){
   boolean[] valid = new boolean[str.length];
   for(int i=0;i<str.length;i++){
     valid[i] = isValid(str[i]);
   }
   return valid;
 }

 public static boolean isValid(String str){
  if(str.length()%2 !=0)
   return false;
  
  Deque<Character> stack = new ArrayDeque<Character>();
  for(int i=0;i<str.length();i++){
    Character ch = str.charAt(i);
    switch(ch){
    case '[':
      stack.push(']');break;
    case '{':
      stack.push('}');break;
    case '(':
      stack.push(')');break;
    case ']':
    case '}':
    case ')':
      if(stack.isEmpty() || stack.pop()!=ch) return false;
    }
  }
  return stack.isEmpty();
 }

 public static void main(String args[]){
  String[] str = {"[][][", "()()()", "[()]}", "{[({([])})]}"};
  System.out.println(Arrays.toString(str));
  System.out.println(Arrays.toString(ValidParantheses.validParantheses(str)));
 }

}
