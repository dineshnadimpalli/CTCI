import java.util.*;

class BalancedTree{
    static class TreeNode{
        int value;
        TreeNode left, right;
        TreeNode(int n){
            value = n;
            left = right = null;
        }
    }

    static TreeNode root;

    int isBalanced(TreeNode root){
        if(root == null){
            return 0;
        }

    // ***The below code solution is of time complexity O(n^2) for skewed trees
        /*    int lh = treeHeight(root.left);
            int rh = treeHeight(root.right);

            if(Math.abs(lh-rh)<2 && isBalanced(root.left) && isBalanced(root.right)){
                return true;
            }
            
            return false;
        */  
    // End of the solution

        int leftBalanced = isBalanced(root.left);
        if(leftBalanced == -1) return -1;

        int rightBalanced = isBalanced(root.right);
        if(rightBalanced == -1) return -1;

        if(Math.abs(leftBalanced-rightBalanced)>1) return -1;
        
        return Math.max(leftBalanced, rightBalanced) + 1;
    }

    int treeHeight(TreeNode tree){
        if(tree == null){
            return 0;
        }
        return 1+Math.max(treeHeight(tree.left), treeHeight(tree.right));
    }

    public static void main(String[] args){
        BalancedTree t = new BalancedTree();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        int result = t.isBalanced(root);
        if(result == -1){
            System.out.println("The tree is not balanced");
        }else {
            System.out.println("The tree is balanced");
        }
    }
}