import java.util.*;

class MinStackElement {
    Stack<Integer> s;
    int minVal;

    MinStackElement() {
        s = new Stack<Integer>();
    }

    void printStack(){
        System.out.println(Arrays.toString(s.toArray()));
    }

    void push(int item) {
        if (s.isEmpty()) {
            minVal = item;
            s.push(item);
            System.out.println("Minvalue is " + minVal);

            return;
        }

        if (item < minVal) {
            int temp = 2 * item - minVal;
            s.push(temp);
            minVal = item;
        } else {
            s.push(item);
        }

        System.out.println("Minvalue is " + minVal);
    }

    void pop() {
        if (s.isEmpty()) {
            System.out.println("Pop is not possible and stack is empty");
        }

        int top = s.pop();
        if (top < minVal) {
            minVal = 2 * minVal - top;
        }

        System.out.println("Popped element is "+ top + " and min value is "+ minVal);
    }

    void peek() {
        if (s.isEmpty()) {
            System.out.print("Stack is empty");
        }

        int top = s.peek();

        if (top < minVal) {
            System.out.println("minvalue is " + minVal);
        } else {
            System.out.println("minVal is " + top);
        }
    }

    public static void main(String[] args) {
        MinStackElement s = new MinStackElement();
        s.push(1);
        s.push(2);
        s.push(0);
        s.push(-3);
        s.push(1);
        // s.peek();
        s.pop();
        s.printStack();
    }
}
