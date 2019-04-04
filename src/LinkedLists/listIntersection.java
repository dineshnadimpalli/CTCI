public class listIntersection{
    static Node head1, head2;

    static class Node {
        int data;
        Node next;

        public Node(int n) {
            data = n;
        }
    }

    public void print(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    int getCount(Node c) {
        int count = 0;
        while (c != null) {
            count++;
            c = c.next;
        }
        return count;
    }
    
    int getIntersection(Node a, Node b) {
        int c1 = getCount(a);
        int c2 = getCount(b);
        // System.out.println(c1 + " " + c2);
        if (c1 > c2) {
            int diff = c1 - c2;
            return intersecData(diff, a, b);
        } else {
            int diff = c2 - c1;
            return intersecData(diff, b, a);
        }
    }
    
    int intersecData(int n, Node high, Node low) {
        for (int i = 0; i < n; i++) {
            high = high.next;
        }
        // print(high);
        while (high != null && low != null) {
            if (high.data == low.data) {
                return high.data;
            }
            high = high.next;
            low = low.next;
        }
        return -1;
        
    }
    public static void main(String[] args) {
        listIntersection list = new listIntersection();

        list.head1 = new Node(2);
        list.head1.next = new Node(3);
        list.head1.next.next = new Node(1);
        list.head1.next.next.next = new Node(7);

        list.print(list.head1);

        list.head2 = new Node(4);
        list.head2.next = new Node(5);
        list.head2.next.next = new Node(6);
        list.head2.next.next.next = new Node(7);

        list.print(list.head2);
        int inter = list.getIntersection(head1, head2);
        System.out.println(inter);
    }
}