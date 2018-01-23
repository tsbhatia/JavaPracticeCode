/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
class SwapPairNode{
 static class Node{
  public int value;
  public Node next;
  public Node(int value){
   this.value = value;
  }
 }

 public static Node swapNode(Node head){
   Node node = new Node(0);
   node.next = head;
   Node current = node;
   while(current.next != null && current.next.next != null){
    Node first = current.next;
    Node second = current.next.next;
    first.next = second.next;
    second.next = first;
    current.next = second;
    current = current.next.next;
   }
   return node.next;
 }
 public static void print(Node node){
   while(node!=null){
     System.out.print(node.value+ "->");
     node = node.next;
   }
   System.out.println("null");
 }
 public static void main(String args[]){
   Node root = new Node(1);
   root.next = new Node(2);
   root.next.next = new Node(3);
   root.next.next.next = new Node(4);
   root.next.next.next.next = new Node(5);
   print(root);
   Node head = swapNode(root);
   print(head);
 }
}
