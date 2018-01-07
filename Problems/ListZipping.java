
/*
Given a linked list
e.g 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
Convert the linked list into a Zip List
i.e. 0 -> 6 -> 1 -> 5 -> 2 -> 4 -> 3

This can be solved as
1) First find the mid point of the list
2) Reverse the second half of the list
3) Create new list by alternatively seleting nodes
 from each list
*/

class ListZipping{
 private static class ListNode{
  public int value;
  public ListNode next;
  public ListNode(int val){
   this.value = val;
   this.next = null;
  }
 }

 public static ListNode getZipList(ListNode node){
  // find the middle node of the list
  ListNode slow = node;
  ListNode fast = node;
  while(fast != null && fast.next != null){
   fast = fast.next.next;
   slow = slow.next;
  }
  
  ListNode firstHalf = node;
  ListNode secondHalf = slow.next;
  slow.next = null;// break the first list
  // reverse the second half
  secondHalf = reverse(secondHalf);
  //print(secondHalf);
  // Alternatively merge  first and second half.
  ListNode firstItr = firstHalf;
  ListNode secondItr = secondHalf;
  while(secondItr != null){
   ListNode temp = secondItr.next;
   secondItr.next = firstItr.next;
   firstItr.next = secondItr;
   firstItr = firstItr.next.next;
   secondItr = temp;
  }
  return node;
 }
 private static ListNode reverse(ListNode node){
  if(node == null || node.next == null)
   return node;
  ListNode pre = null;
  ListNode curr = node;
  ListNode next = null;
  while(curr != null){
   next = curr.next;
   curr.next = pre;
   pre = curr;
   curr = next; 
  }
  node = pre;
  return node;
 }

 private static void print(ListNode node){
  while(node!=null){
   System.out.print(node.value);
   if(node.next != null){
    System.out.print(" -> ");
   }
   node = node.next;
  }
  System.out.println();
 }

 public static void main(String args[]){
  ListNode root = new ListNode(0);
  root.next = new ListNode(1);
  root.next.next = new ListNode(2);
  root.next.next.next = new ListNode(3);
  root.next.next.next.next = new ListNode(4);
  root.next.next.next.next.next = new ListNode(5);
  root.next.next.next.next.next.next = new ListNode(6);
  
  ListZipping.print(root);
  root = ListZipping.reverse(root);
  ListZipping.print(root);
  root = ListZipping.reverse(root);
  ListZipping.print(root);
  root = ListZipping.getZipList(root);
  ListZipping.print(root); 
 }
}
