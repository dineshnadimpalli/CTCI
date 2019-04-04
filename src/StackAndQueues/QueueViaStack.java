import java.util.*;

public class QueueViaStack {

    static class Queue {
        Stack<Integer> s1;
        Stack<Integer> s2;
    }

    static class RecursiveStack {
        Stack<Integer> s3;
    }

    static void push(Stack<Integer> stack, int val) {
        stack.push(val);
    }
    
    static int pop(Stack<Integer> stack) {
        int x = stack.pop();
        return x;        
    }
    
    static void enQueue(Queue q, int val) {
        push(q.s1, val);
    }

    static void recursiveEnQueue(RecursiveStack q, int val) {
        push(q.s3, val);
    }
    
    static int deQueue(Queue q) {
        int x;
        if (q.s1.isEmpty() && q.s2.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(0);
        }
        if (q.s2.isEmpty()) {
            while (!q.s1.isEmpty()) {
                x = pop(q.s1);
                push(q.s2, x);
            }
        }
        return pop(q.s2);
    }

    static int recursiveDeQueue(RecursiveStack q) {
        int x, res = 0;
        if (q.s3.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(0);
        }

        else if (q.s3.size() == 1) {
            return pop(q.s3);
        }
        
        else {
            x = pop(q.s3);
            res = recursiveDeQueue(q);

            push(q.s3, x);
            return res;
        }
        return 0;
        
    }
    public static void main(String[] args) {
        // Queue q = new Queue();
        // q.s1 = new Stack<>();
        // q.s2 = new Stack<>();
        RecursiveStack q = new RecursiveStack();
        
        q.s3 = new Stack<>();
        // deQueue(q);
        recursiveEnQueue(q, 1);
        recursiveEnQueue(q, 2);
        recursiveEnQueue(q, 3);
        recursiveEnQueue(q, 4);
        // System.out.println(Arrays.toString(q.s1.toArray()));
        // System.out.println(Arrays.toString(q.s2.toArray()));
        System.out.println("The popped element is "+recursiveDeQueue(q));
        System.out.println(Arrays.toString(q.s3.toArray()));
        recursiveEnQueue(q, 5);
        System.out.println("The popped element is "+recursiveDeQueue(q));
        System.out.println(Arrays.toString(q.s3.toArray()));
        // System.out.println(Arrays.toString(q.s2.toArray()));
        // System.out.println(deQueue(q));
        // System.out.println(Arrays.toString(q.s1.toArray()));
        // System.out.println(Arrays.toString(q.s2.toArray()));
        // recursiveDeQueue(q);
        // System.out.println(Arrays.toString(q.s1.toArray()));
        // System.out.println(Arrays.toString(q.s2.toArray()));
    }
}