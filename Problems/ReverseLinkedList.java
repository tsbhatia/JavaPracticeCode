

class ReverseLinkedList{

 private static class Node{
  public int value;
  public Node next;
  public Node(int value){
   this.value = value;
  }
 }

 public static Node reverse(Node node){
  Node curr = node;
  Node pre = null, next = null;
  while(curr != null){
    next = curr.next;
    curr.next = pre;
    pre = curr;
    curr = next;
  }
  return pre;
 }
 public static void print(Node node){
   while(node!=null){
    System.out.print(node.value+" ");
    node = node.next;
   }
   System.out.println();
 }
 public static void main(String args[]){
  Node root = new Node(1);
  root.next = new Node(2);
  root.next.next = new Node(3);
  root.next.next.next = new Node(4);
  print(root); 
  print(reverse(root));
 }
}
