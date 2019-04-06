import java.util.*;

public class TreeListAtEachLevel{
    static class Node{
        int data;
        Node next;
        Node(int n){
            this.data = n;
            this.next = null;
        }
    }

    static class Tree{
        int item;
        Tree left, right;
        Tree(int n){
            this.item = n;
            this.left = null;
            this.right = null;
        }
    }

    ArrayList<Node> ar = new ArrayList<>();

    public void findTreeListAtEachLevel(Tree t){
        Queue q = new LinkedList();
        int numberOfNodes = 0;
        q.add(t);
        while(q.size()>0){
            numberOfNodes = q.size();
            Node head = null;
            Node curr = null;
            while(numberOfNodes>0){
              Tree ln = (Tree)q.remove();
              Node n = new Node(ln.item);
              if(head == null){
                head = n;
                curr = n;
              }
              else {
                curr.next = n;
                curr = curr.next;
              }
              if(ln.left != null) q.add(ln.left);
              if(ln.right != null) q.add(ln.right);
              numberOfNodes--;
            }
            ar.add(head);
        }
        print(ar);
    }

    public void print(ArrayList<Node> t){
        Iterator l = t.iterator();
        while(l.hasNext()){
            Node h = (Node)l.next();
            while(h != null){
                System.out.print(h.data+" ");
                h = h.next;
            }
            System.out.println();
        }
    }

    public void printTree(Tree t){
        if(t == null){
            return;
        }
        printTree(t.left);
        System.out.print(t.item+" ");
        printTree(t.right);
    }

    public static void main(String[] args){
        TreeListAtEachLevel result = new TreeListAtEachLevel();

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        // result.printTree(root);
        result.findTreeListAtEachLevel(root);
    }
}