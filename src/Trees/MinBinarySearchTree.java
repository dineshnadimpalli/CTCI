
class MinBinarySearchTree {

    static class Node {
        int item;
        Node left, right;

        Node(int n) {
            item = n;
            left = right = null;
        }

    }

    public Node minBinary(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = minBinary(arr, start, mid - 1);
        root.right = minBinary(arr, mid + 1, end);

        return root;
    }

    void printInOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        printInOrderTraversal(node.left);
        System.out.print(node.item + " ");
        printInOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        MinBinarySearchTree tree = new MinBinarySearchTree();
        int[] arr = { 2, 3, 6, 7, 8, 9, 12, 15, 16, 18, 20 };
        Node finalNode = tree.minBinary(arr, 0, arr.length - 1);
        tree.printInOrderTraversal(finalNode);
    }
}