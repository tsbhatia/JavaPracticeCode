/*
Extract Leaves of a Binary Tree in a Doubly Linked List.
Given a Binary Tree, extract all leaves of it in a Doubly Linked List (DLL). 
Note that the DLL need to be created in-place. 
Assume that the node structure of DLL and Binary Tree is same, 
only the meaning of left and right pointers are different. 
In DLL, left means previous pointer and right means next pointer.
*/

class ExtractLeaves{
 
 // Root of binary tree
 public Node root;
 // Head of Linked list 
 public static Node head;
 // temp Node
 public static Node prev;

 public static Node extractLeaves(Node root){
  if(root == null)
    return null;
  else if(root.left == null && root.right == null){
   // This is a leaf node
   if(head == null){
     head = root;
     prev = root;
   }else {
     prev.right = root;
     root.left = prev;
     prev = root;
   }
   return null;
  }
  root.left = extractLeaves(root.left);
  root.right = extractLeaves(root.right);
  return root;
    
 } 
 private static class Node{
   public int value;
   public Node left, right;
   public Node(int value){
    this.value = value;
    left = right = null;
   }
 }

 private static void print(Node root){
   if(root==null)
     return;
   while(root != null){
    System.out.print(root.value);
    root = root.right;
    if(root != null){
     System.out.print(" -> ");
    }
   }
  System.out.println();
 }
 public static void main(String args[]){
  Node root = new Node(1);
  root.left = new Node(2);
  root.right = new Node(3);
  root.left.left = new Node(4);
  root.left.right = new Node(5);
  root.left.left.left = new Node(7);
  root.left.left.right = new Node(8);

  root.right.right = new Node(6);
  root.right.right.left = new Node(9);
  root.right.right.right = new Node(10);
  
  ExtractLeaves.extractLeaves(root);
  ExtractLeaves.print(ExtractLeaves.head);
  
 }

}
