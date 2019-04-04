public class partitionList {

    public Node head;

    public class Node {
        int data;
        Node next;

        public Node(int n) {
            this.data = n;
        }
    }

    public void addNode(int d) {
        Node new_node = new Node(d);
        if (this.head == null) {
            this.head = new_node;
        } else {
            new_node.next = head;
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
        head = prev;
        return head;
    }

    public void print(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();

    }

    Node partition(Node n, int val) {
        Node smallerHead = null;
        Node smallerLast = null;
        Node equalHead = null;
        Node equalLast = null;
        Node greatHead = null;
        Node greatLast = null;

        while (n != null) {
            if (n.data == val) {
                if (equalHead == null) {
                    equalHead = equalLast = n;
                } else {
                    equalLast.next = n;
                    equalLast = equalLast.next;
                }
            }

            else if (n.data < val) {

                if (smallerHead == null) {
                    smallerHead = smallerLast = n;
                } else {
                    smallerLast.next = n;
                    smallerLast = n;
                }
            }

            else {
                if (greatHead == null) {
                    greatHead = greatLast = n;
                } else {
                    greatLast.next = n;
                    greatLast = n;
                }
            }
            n = n.next;
        }

        // partitionList temp = new partitionList();

        if (greatLast != null) {
            greatLast.next = null;
        }

        if (smallerHead == null) {
            if (equalHead == null) {
                return greatHead;
            }
            equalLast.next = greatHead;
            return equalHead;
        }

        if (equalHead == null) {
            smallerLast.next = greatHead;
            return smallerHead;
        }

        smallerLast.next = equalHead;
        equalLast.next = greatHead;
        head = smallerHead;
        return head;
    }

    public static void main(String[] args) {
        partitionList list = new partitionList();
        list.addNode(5);
        list.addNode(1);
        list.addNode(4);
        list.addNode(9);
        list.addNode(2);
        // list.addNode(8);
        list.addNode(3);
        list.addNode(5);
        list.reverseList(list.head);
        list.print();
        list.partition(list.head, 9);
        list.print();
    }
}