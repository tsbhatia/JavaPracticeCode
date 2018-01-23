/*
Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

*/
class RemoveNthNode{
 static class Node{
   public int value;
   public Node next;
   public Node(int val){
    this.value = val;
   }
 }
 public static Node removeElement(Node root, int n){
   Node head = new Node(0);
   Node slow = head, fast = head;
   slow.next = root;

   for(int i=1;i<=n;i++)
     fast = fast.next;

   while(fast != null){
     slow = slow.next;
     fast = fast.next;
   }

   slow.next = slow.next.next;
   return head.next;
 }
 public static void print(Node root){
   while(root != null){
    System.out.print(root.value+ "->");
    root = root.next;
   }
    System.out.println("null");
 }
 public static void main(String args[]){
   Node root = new Node(1);
   root.next = new Node(2);
   root.next.next = new Node(3);
   root.next.next.next = new Node(4);
   root.next.next.next.next = new Node(5);
   root.next.next.next.next.next = new Node(6);
   
   print(root);
   Node head = removeElement(root, 3);
   print(head);   
 }

}
