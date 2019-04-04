import java.util.*;

public class SortStack {

    public static Stack<Integer> sortedStack(Stack<Integer> normalStack) {
        int temp;
        Stack<Integer> tmp = new Stack<Integer>();
        while (!normalStack.isEmpty()) {
            temp = normalStack.pop();
            while (!tmp.isEmpty() && tmp.peek() > temp) {
                int top = tmp.pop();
                normalStack.push(top);
            }
            ;
            tmp.push(temp);
        }
        return tmp;
    }

    public static void arrangeSort(Stack<Integer> s, int temp) {
        if (s.isEmpty() || s.peek() > temp) {
            s.push(temp);
            return;
        }
        int ele = s.pop();
        arrangeSort(s, temp);
        s.push(ele);
    }
    
    public static void recursiveSort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int temp = s.pop();
            recursiveSort(s);
            arrangeSort(s, temp);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(0);
        // Stack<Integer> tempStack  =  sortedStack(stack);
        recursiveSort(stack);

        // System.out.println(Arrays.toString(tempStack.toArray()));

        System.out.println(Arrays.toString(stack.toArray()));

    }
}