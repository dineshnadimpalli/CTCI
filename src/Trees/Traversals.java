
class Traversals {
    Node root;
    // Traversals(int i)
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

    void printInOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        printInOrderTraversal(node.left);
        System.out.print(node.item + " ");
        printInOrderTraversal(node.right);
    }

    void printPreOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.item + " ");

        printPreOrderTraversal(node.left);
        printPreOrderTraversal(node.right);

    }

    void printPostOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        printPostOrderTraversal(node.left);
        printPostOrderTraversal(node.right);
        System.out.print(node.item + " ");

    }

    public static void main(String[] args) {
        Traversals tree = new Traversals();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);

        tree.printInOrderTraversal(tree.root);
        System.out.println(" is the Inorder traversal for the tree");

        tree.printPreOrderTraversal(tree.root);

        System.out.println("is the Inorder traversal for the tree");

        tree.printPostOrderTraversal(tree.root);

        System.out.println("is the Inorder traversal for the tree");

    }
}