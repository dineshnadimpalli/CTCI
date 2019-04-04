public class circularList{
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }
    
    void addNode(int n) {
        Node new_node = new Node(n);
        if (head == null) {
            head = new_node;
        } else {
            new_node.next = head;
            head = new_node;
        }
    }

    int isLoop() {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println(slow.data);
                return -1;
            }
        }
        System.out.println("No Loop");
        return -1;
    }

    void print() {
        while (head != null) {
            System.out.print(head.data + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        circularList list = new circularList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.head.next.next.next= list.head;
        // list.print();
        // System.out.println(list.head.data);
        // System.out.println(list.head.next.data);
        // System.out.println(list.head.next.next.data);
        // System.out.println(list.head.next.next.next.data);

        list.isLoop();
    }
}