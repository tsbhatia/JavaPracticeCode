/*
Binary Tree
     A
   /   \
  B     C
 / \    /\
D   E  F  G

Breadth First search is also like level order search... 
Output should printed as A B C D E F G

Take constant space to achieve the problem. 
Time optimization is not needed. O(n^2)

Approch here is using bitwise operation
let 0 bit = left, 1 bit = right
if root node is 1 = A
then 
10 is start from root and go to left  = B
11 is start from root and go to right = C

100 = D
101 = E

110 = F
111 = G
.. and so on. 
*/

class BinaryTreeBFSConstantSpace {

	public static void traverseTree(Node root, int h) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		int level = 2; // starting from second level 
		while (level <= h) { // while less than equal to height of tree
			int start = (int) Math.pow(2, level - 1); // starting count 
			int end = (int) Math.pow(2, level); // ending count
			while (start < end) { 
				Node node = root; // start from root
				int j = level-1; // number of bits to check
				while (j > 0) {
					long mask = 1L << (j - 1); // check from one less than MSB as 
                                                                   // MSB is for root
					long res = start & mask;
					if (res == 0) { // reset bit go to left i.e even
						if (node.left != null) {
							node = node.left;
						}else {
                                                  break;
                                                }
					} else { // else go to right
						if (node.right != null) {
							node = node.right;
						}else
                                                   break;
					}
					j--;
				}
                                if(j == 0)
				    System.out.print(node.value+ " ");
				start++;
			}
			level++;
		     
		}
                System.out.println();
	}

	public static class Node {
		public String value;
		public Node left;
		public Node right;

		public Node(String val) {
			this.value = val;
		}
	}

	public static void main(String args[]) {
		Node root = new Node("A");
		root.left = new Node("B");
		root.right = new Node("C");
		root.left.left = new Node("D");
		root.left.right = new Node("E");
		root.right.left = new Node("F");
		root.right.right = new Node("G");
                root.right.right.left = new Node("H");
		System.out.println("Traversing tree ");
		traverseTree(root, 4);
	}
}
