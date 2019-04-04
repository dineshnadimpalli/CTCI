class palindromeList {
    static Node head; 
  
    static class Node { 
  
        String data; 
        Node next; 
  
        Node(String d) { 
            data = d; 
            next = null; 
        } 
    } 

    // A utility function to check if str is palindrome
    // or not
    boolean isPalidromeUtil(String str) {
        int len = str.length();
        // System.out.println(str);
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i -1)) {
                return false;
            }
        }
        return true;
    }

    // Returns true if string formed by linked
    // list is palindrome
    boolean isPalindrome() {
        Node temp = head;
        
        String str = "";
        while (temp != null) {
            str = str.concat(temp.data);
            temp = temp.next;
        }
        return isPalidromeUtil(str);
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        palindromeList list = new palindromeList();
        list.head = new Node("a");
        list.head.next = new Node("d");
        list.head.next.next = new Node("d");
        list.head.next.next.next = new Node("c");
        list.head.next.next.next.next = new Node("a");

        System.out.println(list.isPalindrome());

    }
}