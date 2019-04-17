import java.util.*;

class IsBST{
    static class TreeNode{
        int value;
        TreeNode left, right;
        TreeNode(int n){
            value = n;
            left = right = null;
        }
    }

    static TreeNode root;

    int isBST(TreeNode head){
       if(head == null){
           return 0;
       }
       System.out.println("head value: "+head.value);
       int isLeftBST = isBST(head.left);
       System.out.println("head left: "+isLeftBST);
       int isRightBST = isBST(head.right);

       System.out.println("head right: "+isRightBST);
       
       

       System.out.println("root: "+root.value);


       if(isLeftBST != 0 && isRightBST != 0){
        if(isLeftBST == -1 || isLeftBST > head.value || isLeftBST > root.value){
            return -1;
        }
        if(isRightBST == -1 || head.value < isRightBST || isRightBST < root.value){
            return -1;
        }
       }     

       return head.value;
    }

    public static void main(String[] args){
        IsBST t = new IsBST();
        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);

        int result = t.isBST(root);
        if(result == -1){
            System.out.println("The tree is not a BST");
        }else {
            System.out.println("The tree is a BST");
        }
    }
}