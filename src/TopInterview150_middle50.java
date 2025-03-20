import java.util.*;


@SuppressWarnings({"unused", "Duplicates"})
public class TopInterview150_middle50 {

    public static void main(String[] args) {
        TopInterview150_middle50 solution = new TopInterview150_middle50();
        int n = 2;
        int m = 2;
        int k = 3;
        int[] list1 = {2, 5};
        int[] list2 = {3, 4, 5, 1, 2, 0, 0, 0};
        int[][] matrix = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
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
        System.out.println(solution.evalRPN(strings));
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
}

