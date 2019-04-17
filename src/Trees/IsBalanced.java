
class IsBalanced {
    Node root;
    Node prev = null;
    // IsBalanced(int i)
    // {
    // root= new Node(i);
    // }

    static class Node {
        int item;
        Node left, right;

        Node(int n) {
            item = n;
            left = right = null;
        }

    }

    boolean isBST()  { 
        return isBSTUtil(root, Integer.MIN_VALUE, 
                               Integer.MAX_VALUE); 
    } 
  
    /* Returns true if the given tree is a BST and its 
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max) 
    { 
        /* an empty tree is BST */
        if (node == null) 
            return true; 
  
        /* false if this node violates the min/max constraints */
        if (node.item < min || node.item > max) 
            return false; 
  
        /* otherwise check the subtrees recursively 
        tightening the min/max constraints */
        // Allow only distinct values 
        return (isBSTUtil(node.left, min, node.item-1) && 
                isBSTUtil(node.right, node.item+1, max)); 
    }

    boolean isBalanced(Node node) {
        if (node != null) {
            if(!isBalanced(node.left)){
                return false;
            }
            
            if(prev != null && prev.item > node.item){
                return false;
            }
            prev = node;
            System.out.println(node.item+" ");
            return isBalanced(node.right);
        }
        return true;
    }

    public static void main(String[] args) {
        IsBalanced tree = new IsBalanced();
        tree.root = new Node(5);
        tree.root.left = new Node(2);
        // tree.root.right = new Node(7);  /*Is a BST*/
        tree.root.right = new Node(4);  /*Not a BST*/
        tree.root.left.left = new Node(1);

        // boolean result = tree.isBalanced(tree.root);

        boolean result = tree.isBST();
        
        if(result){
            System.out.println("The tree is a BST");
        } else {
            System.out.println("The tree is not a BST");
        }
    }
}