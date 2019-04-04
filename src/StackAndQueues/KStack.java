public class KStack {
    static class KStackArray{
        int arr[];
        int next[];
        int top[];
        int free;
        int n, k;

        //Constructor
        KStackArray(int k1, int n1) {
            k = k1;
            n = n1;
            arr = new int[n];
            next = new int[n];
            top = new int[k];

            for (int i = 0; i < n; i++) {
                next[i] = i + 1;
            }

            for (int i = 0; i < k; i++) {
                top[i] = -1;
            }

            free = 0;
            next[n - 1] = -1;
        }

        boolean isFull() {
            return (free == -1);
        }

        boolean isEmpty(int stack) {
            return (top[stack] == -1);
        }

        void push(int stack, int item) {
            if (isFull()) {
                System.out.println("Stack Overflow happened");
                return;
            }
            int i = free;
            free = next[i];
            next[i] = top[stack];
            top[stack] = i;
            arr[i] = item;

        }

        int pop(int stack) {
            if (isEmpty(stack)) {
                System.out.println("Stack underflow");
            }
            int i = top[stack];
            top[stack] = next[i];
            next[i] = free;
            free = i;
            return arr[i];
        }
    }
    
    public static void main(String[] args) {
        int k = 3, n = 10;
        KStackArray stk = new KStackArray(k, n);
        stk.push(0, 10);
        stk.push(0, 12);
        stk.push(0, 15);
        stk.push(0, 1);
        // stk.push(0, 5);
        // stk.push(0, 15);
        // stk.push(0, 1);
        // stk.push(0, 5);

        stk.push(1, 32);
        stk.push(1, 43);

        stk.push(2, 20);
        stk.push(2, 70);

        System.out.println("The element popped is " + stk.pop(0));
        System.out.println("The element popped is " + stk.pop(1));
    }
}