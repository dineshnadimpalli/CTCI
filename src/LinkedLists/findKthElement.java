import java.util.Hashtable;

public class findKthElement {
    static node head;

    public static void main(String args[]) {
        findKthElement list = new findKthElement();
        list.addNode(1);
        list.addNode(1);
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(2);

        list.print();
        list.findKthitem(5);
    }

    public void findKthitem(int k) {
        node temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        temp = head;

        for (int i = 1; i < len - k + 1; i++) {
            temp = temp.next;
        }

        System.out.println(temp.data);

    }

    public void print() {
        node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();

    }

    public void print(node  n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();

    }

    public void addNode(int d) {
        node n = new node(d);
        if (this.head == null) {
            this.head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    static class node {
        node next;
        int data;

        public node(int d) {
            this.data = d;
        }
    }

    node reverseList(node n) {
        node prev = null;
        node current = n;
        node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node rev = prev;
        return rev;
    }
}