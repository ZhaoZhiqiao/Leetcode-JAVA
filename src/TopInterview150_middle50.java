import java.util.*;
import java.util.stream.Collectors;

public class TopInterview150_middle50 {

    public static void main(String[] args) {
        TopInterview150_middle50 solution = new TopInterview150_middle50();
        int n = 2;
        int m = 2;
        int k = 3;
        int[] list1 = {2, 5};
        int[] list2 = {3, 4, 5, 1, 2, 0, 0, 0};
        int[][] matrix = {{10,16}, {2,8}, {1,6}, {7,12}};
        String str1 = "/.../a/../b/c/../d/./";
        String str2 = "(]";
        String[] strings = {"dddd", "dddd"};
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
        System.out.println(solution.simplifyPath(str1));
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
        for(char c:chars){
            if((!stack.isEmpty()) && ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{') )){
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] foldNames = path.split("/+");
        StringBuilder newPath = new StringBuilder("/");
        for (int i = 1; i <foldNames.length;i++){
            if ("..".equals(foldNames[i])){
                if (!deque.isEmpty()){
                    deque.pollLast();
                }
            }
            else if (!".".equals(foldNames[i])){
                deque.offerLast(foldNames[i]);
            }
        }
        while (!deque.isEmpty()){
            newPath.append(deque.peekFirst());
            deque.pollFirst();
            if (!deque.isEmpty()) newPath.append("/");
        }
        return newPath.toString();
    }
}

