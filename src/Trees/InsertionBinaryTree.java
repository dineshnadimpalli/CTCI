import java.util.*;

class InsertionBinaryTree{
    static class TreeNode{
        int key;
        TreeNode right, left;
        TreeNode(int data){
            this.key = data;
            this.right = this.left = null;
        }
    }

    static TreeNode root;

    InsertionBinaryTree(){
        root = null;
    }

    TreeNode insertNode(TreeNode root, int key){
        if(root == null){
            return (new TreeNode(key));
        }
        if(key < root.key){
            root.left = insertNode(root.left, key);
        }
        else if(key > root.key){
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.key+" ");
        inOrder(root.right);
    }

    public static void main(String[] args){
        InsertionBinaryTree t = new InsertionBinaryTree();
        root = t.insertNode(root, 5);
        t.insertNode(root, 3);
        t.insertNode(root, 10);
        t.insertNode(root, 4);
        t.insertNode(root, 8);
        t.insertNode(root, 1);

        t.inOrder(root);
    }
}