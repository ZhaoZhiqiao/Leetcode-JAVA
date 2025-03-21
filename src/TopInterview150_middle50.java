import DataStructrue.ListNode;
import DataStructrue.Node;

import java.util.*;


@SuppressWarnings({"unused", "Duplicates"})
public class TopInterview150_middle50 {

    public static void main(String[] args) {
        TopInterview150_middle50 solution = new TopInterview150_middle50();
        int n = 3;
        int m = 2;
        int k = 3;
        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {5, 6, 4};
        int[][] matrix = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Integer[][] integers = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        ListNode linkListHead1 = ListNode.fromArray(list1);
        ListNode linkListHead2 = ListNode.fromArray(list2);
        String str1 = "/.../a/../b/c/../d/./";
        String str2 = "(]";
        String[] strings = {"4", "13", "5", "/", "+"};
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


//        System.out.println(solution.isValid(str1));
//        System.out.println(solution.simplifyPath(str1));
//        System.out.println(solution.evalRPN(strings));
//        ListNode current = linkListHead1;
//        while(current.next != null){
//            current = current.next;
//        }
//        current.next = linkListHead1;
//        System.out.println(solution.hasCycle(linkListHead1));
//        System.out.println(solution.mergeTwoLists(linkListHead1, linkListHead2));
//
//        System.out.println(solution.reverseBetween(linkListHead1, 2, 9));
        System.out.println(solution.reverseKGroup(linkListHead1, n));
        //-----------------------------test--------------------------------------------
//        System.out.println("m: " + m);
//        System.out.println("n: " + n);
//        System.out.println("k: " + k);
//        System.out.println("list 1:  " + Arrays.toString(list1));
//        System.out.println("list 2:  " + Arrays.toString(list2));
//        System.out.println("matrix:  " + Arrays.deepToString(matrix));
//        System.out.println("str1: " + str1);
//        System.out.println("str2: " + str2);
//        System.out.println("strings: " + Arrays.toString(strings));
//        System.out.println("board: " + Arrays.deepToString(board));
        //-----------------------------------------------------------------------------
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if ((!stack.isEmpty()) && ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] foldNames = path.split("/+");
        StringBuilder newPath = new StringBuilder("/");
        for (int i = 1; i < foldNames.length; i++) {
            if ("..".equals(foldNames[i])) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (!".".equals(foldNames[i])) {
                deque.offerLast(foldNames[i]);
            }
        }
        while (!deque.isEmpty()) {
            newPath.append(deque.peekFirst());
            deque.pollFirst();
            if (!deque.isEmpty()) newPath.append("/");
        }
        return newPath.toString();
    }

    @SuppressWarnings("all")
    public class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }

        }

        public void pop() {
            if (minStack.peek().equals(stack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n, m;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    n = stack.pop();
                    m = stack.pop();
                    stack.push(m + n);
                    break;
                case "-":
                    n = stack.pop();
                    m = stack.pop();
                    stack.push(m - n);
                    break;
                case "*":
                    n = stack.pop();
                    m = stack.pop();
                    stack.push(m * n);
                    break;
                case "/":
                    n = stack.pop();
                    m = stack.pop();
                    stack.push(m / n);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);

        int sign = 1, result = 0, n = s.length(), i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = !stack.isEmpty() ? stack.peek() : 1;
                i++;
            } else if (s.charAt(i) == '-') {
                sign = !stack.isEmpty() ? -stack.peek() : 1;
                i++;
            } else if (s.charAt(i) == '(') {
                stack.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                stack.pop();
                i++;
            } else {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += (sign * num);
            }
        }
        return result;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        boolean flag = false;
        if (slow != null && slow.next != null) {
            ListNode fast = head.next;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = l1.val + l2.val;
        boolean flag = x >= 10;
        ListNode head = new ListNode(x % 10);
        ListNode current = head;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            x = flag ? (l1.val + l2.val) + 1 : (l1.val + l2.val);
            flag = x >= 10;
            current.next = new ListNode(x % 10);
            current = current.next;
        }

        while (l1.next != null) {
            l1 = l1.next;
            x = flag ? l1.val + 1 : l1.val;
            flag = x >= 10;
            current.next = new ListNode(x % 10);
            current = current.next;

        }

        while (l2.next != null) {
            l2 = l2.next;
            x = flag ? l2.val + 1 : l2.val;
            flag = x >= 10;
            current.next = new ListNode(x % 10);
            current = current.next;
        }

        if (flag) {
            current.next = new ListNode(1);
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        if (list1 == null || list2 == null) {
            head.next = list1 == null ? list2 : list1;
        } else {
            ListNode current = head;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    current.next = new ListNode(list1.val);
                    current = current.next;
                    list1 = list1.next;
                } else {
                    current.next = new ListNode(list2.val);
                    current = current.next;
                    list2 = list2.next;
                }
            }
            while (list1 != null) {
                current.next = new ListNode(list1.val);
                current = current.next;
                list1 = list1.next;
            }
            while (list2 != null) {
                current.next = new ListNode(list2.val);
                current = current.next;
                list2 = list2.next;
            }
        }
        return head.next;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            Node temp = new Node(current.val);
            temp.next = current.next;
            current.next = temp;
            current = temp.next;
        }
        current = head;
        while (current != null) {
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }

        Node oldHead = head;
        Node newHead = head.next;

        current = newHead.next;

        while (current.next != null) {
            oldHead.next = current.next;
            oldHead = oldHead.next;

            current.next = current.next.next;
            current = current.next;
        }
        oldHead.next = null;
        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode current = prev.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, current = dummy, next = head, temp = dummy;
        int target =  k;
        for (int left = 1, right = left + k - 1; current.next != null; left += k, right = left + k - 1,target = k) {
            temp = current;
            while (temp.next != null && target > 0) {
                temp = temp.next;
                target--;
            }
            if (target > 0) break;

            prev = current;
            current = prev.next;
            for (int i = 0; i < right - left && current.next != null; i++) {
                next = current.next;
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
        }
        return dummy.next;
    }
}

