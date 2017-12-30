import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * This class check for least ancestor for 
two given nodes when given parent node. 
E.g LCA for 5 and 9 is 3 
          1
         / \
        2   3
       /   / \
      4   5   6
       \     / \
        7   8   9
This can be acheive by saving all ancestor
of one node in hashmap and then look for common
ancestor while going through all ancestor of
second node.
</pre>
 * @author taran
 *
 */
class LeastCommonAncestor{
 
 class Node<T>{
  public T data;
  public Node<T> parent;
  public Node<T> left, right;
  public Node(T data){
   this.data = data;
  }
 }

 public Integer getAncestor(Node<Integer> node1, Node<Integer> node2){
  Node<Integer> ancestor = checkAncestor(node1, node2);
  return ancestor != null? ancestor.data:null; 
 }

 public Node<Integer> checkAncestor(Node<Integer> node1, Node<Integer> node2){
  Map<Node<Integer>, Node<Integer>> childParent = new HashMap<>();

  while(node1.parent != null){
   childParent.put(node1, node1.parent);
   node1 = node1.parent;
  }
  // This is adding root node in the map
  childParent.put(node1, null);
  
  while(node2.parent != null){
   if(childParent.containsKey(node2.parent)){
    return node2.parent;
   }
   node2 = node2.parent;
  }

  return null;
  
 }

 public Node<Integer> sampleData(){
  Node<Integer> root = new Node<Integer>(1);
  Node<Integer> left = new Node<Integer>(2);
  Node<Integer> right = new Node<Integer>(3);
  
  left.parent = root;
  root.left = left;
  right.parent = root;
  root.right = right;
 
 
  left = new Node<Integer>(4);
  right = new Node<Integer>(5);
  
  left.parent = root.left;
  root.left.left = left;
  
  right.parent = root.right;
  root.right.left = right;

  right = new Node<Integer>(6);
  right.parent = root.right;
  root.right.right = right;


  left = new Node<Integer>(7);
  right = new Node<Integer>(8);
  
  left.parent = root.left.left;
  root.left.left.right = left;

  right.parent = root.right.right;
  root.right.right.left = right;

  right = new Node<Integer>(9);
  right.parent = root.right.right;
  root.right.right.right = right;
  
  return root;
 }
 
 public void visualize(Node<Integer> root){
  if(root == null){
     System.out.println("Root node is null");
     return;
  }

  ArrayDeque<Node<Integer>> arry = new ArrayDeque<>();  
  arry.add(root);
  while(!arry.isEmpty()){
    Node<Integer> node = arry.pollFirst();
    System.out.println("Node: "+ node.data);
    if(node.left != null){
     System.out.println("left: "+ node.left.data);
     arry.add(node.left);
    }
    if(node.right != null){
     System.out.println("right: "+ node.right.data);
     arry.add(node.right);
    }
    System.out.println("");
  }
  
 }
 public static void main(String args[]){
  LeastCommonAncestor bt = new LeastCommonAncestor();
  Node<Integer> root = bt.sampleData();
  bt.visualize(root);
  Node<Integer> node1 = root.left.left;
  Node<Integer> node2 = root.right.right;
  Integer lca = bt.getAncestor(node1,node2);
  System.out.println(String.format("Node: %d,%d has LCM: %d ", node1.data, node2.data, lca));

  node1 = root.right.left;
  node2 = root.right.right.left;
  lca = bt.getAncestor(node1,node2);
  System.out.println(String.format("Node: %d,%d has LCM: %d ", node1.data, node2.data, lca));
 }  

}



