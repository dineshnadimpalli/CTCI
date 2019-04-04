public class deleteNode {

    static Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        deleteNode n = new deleteNode();
        n.addNode(1);
        n.addNode(2);
        n.addNode(3);
        n.addNode(4);
        n.addNode(5);
        n.reverse();
        n.print();
        n.delete(5);
        n.print();
    }
    
    public void delete(int n) {
        Node temp = head;
        Node prev = null;
        if (head == null) {
            return;
        }

        if (temp != null && temp.data == n) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != n) {
            prev = temp;
            temp = temp.next;
        }
        
        if (temp == null)
            return;
        
        prev.next = temp.next;
    }

    public void addNode(int n) {
        Node new_node = new Node(n);
        if (this.head == null) {
            this.head = new_node;
        } else {
            new_node .next = head;
            head = new_node;
        }
    }
    
    public void print() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();

    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}