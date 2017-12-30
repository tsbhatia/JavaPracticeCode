/*
This class check for If the given binary tree is
Symmetric i.e binary tree should be mirrors from 
the vertical access to the root. 
          1
         / \
        2   2
       /     \
      3       3
       \     /
        4   4  
*/
class SymmetricTree{
 
 class Node<T>{
  public T data;
  public Node<T> left, right;
  public Node(T data){
   this.data = data;
  }
 }

 public boolean isSymmetricTree(Node<Integer> root){
  return checkSymmetric(root.left, root.right);
 }

 public boolean checkSymmetric(Node<Integer> left, Node<Integer> right){
  if(left == null && right == null){
   System.out.println("left and right are null");
   return true;
  }else if(left != null && right != null){
    System.out.println(String.format("left: %d, right: %d", left.data, right.data));
    return left.data == right.data && checkSymmetric(left.left, right.right)
                                   && checkSymmetric(left.right, right.left);
  }
  // else it not symmetric if any of them false.
  return false;
  
 }

 public Node<Integer> sampleData(){
  Node<Integer> root = new Node<Integer>(1);
  Node<Integer> left = new Node<Integer>(2);
  Node<Integer> right = new Node<Integer>(2);
  
  root.left = left;
  root.right = right;
 
  left = new Node<Integer>(3);
  right = new Node<Integer>(3);
  
  root.left.left = left;
  root.right.right = right;

  left = new Node<Integer>(4);
  right = new Node<Integer>(4);
  
  root.left.left.left = left;
  root.right.right.right = right;

  return root;
 }
 
 public static void main(String args[]){
  SymmetricTree bt = new SymmetricTree();
  Node<Integer> root = bt.sampleData();
  System.out.println(bt.isSymmetricTree(root));
 }  

}



