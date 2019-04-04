public class sumList {

    static Node head1;
    static Node head2;

    public class Node {
        int data;
        Node next;

        public Node(int n) {
            this.data = n;
        }
    }

    public Node addnode(Node head, int d) {
        Node new_node = new Node(d);
        if (head == null) {
            head = new_node;
        } else {
            new_node.next = head;
            head = new_node;
        }
        head1 = head;
        return head1;
    }

    public Node addsecNode(Node head, int d) {
        Node new_node = new Node(d);
        if (head == null) {
            head = new_node;
        } else {
            new_node.next = head;
            head = new_node;
        }
        head2 = head;
        return head2;
    }

    Node reverseList(Node n) {
        Node prev = null;
        Node current = n;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void print(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();

    }

    Node sumOfList(Node n1, Node n2) {
        Node temp = null;
        Node res = null;
        Node prev = null;
        int carry = 0, sum;

        while (n1 != null || n2 != null) {
            // Resultant sum is depends on:
            // 1. carry
            // 2. next digit of 1st list
            // 3. next digit of 2nd list
            // System.out.println(carry);
            sum = carry + (n1 != null ? n1.data : 0) + (n2 != null ? n2.data : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new Node(sum);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;

            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        
        if (carry > 0) {
            temp.next = new Node(carry);
        }
        return res;
    }

    public static void main(String[] args) {
        sumList list = new sumList();
        list.addnode(list.head1, 7);
        list.addnode(list.head1, 2);

        list.addnode(list.head1, 1);
        list.addnode(list.head1, 2);
        // Node rev1 = list.reverseList(list.head1);
        list.print(list.head1);


        list.addsecNode(list.head2, 3);
        list.addsecNode(list.head2, 4);

        list.addsecNode(list.head2, 3);
        list.addsecNode(list.head2, 8);
        // Node rev2 = list.reverseList(list.head2);
        list.print(list.head2);

        
        Node res = list.sumOfList(list.head1, list.head2);
        Node rev2 = list.reverseList(res);

        list.print(rev2);

    }
}