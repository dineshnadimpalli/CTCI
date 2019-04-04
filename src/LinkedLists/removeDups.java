import java.util.Hashtable;

public class removeDups {
    static node head;

    public static void main(String args[]) {
        removeDups list = new removeDups();
        list.addNode(1);
        list.addNode(1);
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(2);

        list.print();
        // node reverse = list.reverseList(list.head);
        // list.print(reverse);
        list.deleteDupsNoStorage(list.head);
        System.out.println();
        list.print();
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

    public void deleteDups(node n) {
        Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
        node prev = null;

        while (n != null) {
            if (table.containsKey(new Integer(n.data))) {
                prev.next = n.next; // skip the previously stored references next node
            } else {
                table.put(new Integer(n.data), true);
                prev = n; // stores a reference to n
            }

            n = n.next;
        }
    }

    public void deleteDupsNoStorage(node n) {
        node current = n;

        while (current != null) {
            node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

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