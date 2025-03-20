import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings({"unused","Duplicates"})
public class TopInterview150_top50 {

    public static void main(String[] args) {
        TopInterview150_top50 solution = new TopInterview150_top50();
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

//        solution.merge(list1, 3, list2, 3);
//        System.out.println(solution.removeElement(list1, m));
//        System.out.println(solution.removeDuplicates(list1));
//        System.out.println(solution.removeDuplicates2(list1));
//        System.out.println(solution.majorityElement(list1));
//        solution.rotate(list1, k);
//        System.out.println(solution.maxProfit(list1));
//        System.out.println(solution.maxProfit2(list1));
//        System.out.println(solution.canJump(list1));
//        System.out.println(solution.jump(list1));
//        System.out.println(hIndex(solution.list1));
//        list2 = productExceptSelf(solution.list1);
//        System.out.println(solution.canCompleteCircuit(list1, list2));
//        System.out.println(solution.candy(list1));
//        System.out.println(solution.trap(list1));
//        System.out.println(solution.(str1));
//        System.out.println(solution.intToRoman(n));
//        System.out.println(solution.lengthOfLastWord(str1));
//        System.out.println(solution.longestCommonPrefix(strings));
//        System.out.println(solution.reverseWords(str1));
//        System.out.println(solution.convert(str1, n));
//        System.out.println(solution.strStr(str1,str2));
//        System.out.println(solution.fullJustify(strings, n));
//        System.out.println(solution.isPalindrome(str1));
//        System.out.println(solution.isSubsequence(str1, str2));
//        list2 = solution.twoSum2(list1, n);
//        System.out.println(solution.maxArea(list1));
//        System.out.println(solution.threeSum(list1));
//        System.out.println(solution.minSubArrayLen(n, list1));
//        System.out.println(solution.lengthOfLongestSubstring(str1));
//        System.out.println(solution.findSubstring(str1, strings));
//        System.out.println(solution.minWindow(str1, str2));
//        System.out.println(solution.isValidSudoku(board));
//        System.out.println(solution.spiralOrder(matrix));
//        solution.rotate(matrix);
//        solution.setZeroes(matrix);
//        solution.gameOfLife(matrix);
//        System.out.println(solution.canConstruct(str1, str2));
//        System.out.println(solution.wordPattern(str1, str2));
//        System.out.println(solution.isAnagram(str1, str2));
//        System.out.println(solution.groupAnagrams(strings));
//        System.out.println(solution.wordPattern(str1,str2));
//        list2 = solution.twoSum(list1, n);
//        System.out.println(solution.isHappy(n));
//        System.out.println(solution.containsNearbyDuplicate2(list1, n));
//        System.out.println(solution.longestConsecutive(list1));
//        System.out.println(solution.summaryRanges(list1));
//        System.out.println(Arrays.deepToString(solution.merge(matrix)));
//        System.out.println(Arrays.deepToString(solution.insert(matrix, list1)));
//        System.out.println(solution.findMinArrowShots(matrix));

//        -----------------------------test--------------------------------------------
        System.out.println("m: " + m);
        System.out.println("n: " + n);
        System.out.println("k: " + k);
        System.out.println("list 1:  " + Arrays.toString(list1));
        System.out.println("list 2:  " + Arrays.toString(list2));
        System.out.println("matrix:  " + Arrays.deepToString(matrix));
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("strings: " + Arrays.toString(strings));
        System.out.println("board: " + Arrays.deepToString(board));
//        -----------------------------------------------------------------------------
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (j >= 0 && nums[j] == val) {
            j--;
        }
        if (j < 0) {
            return 0;
        }
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j--];
                while (j > i && nums[j] == val) {
                    j--;
                }
            } else {
                i++;
            }
        }
        return nums[i] == val ? i : i + 1;
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int i = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int i = 2;
        for (int j = 2; j < n; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public int majorityElement(int[] nums) {
        int major = nums[0];
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == major) {
                k++;
            } else {
                k--;
            }
            if (k == 0) {
                major = nums[i + 1];
            }
        }
        return major;
    }

    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        if (k == 0) {
            return;
        }
        int max, min;
        if (nums.length > k) {
            max = nums.length;
            min = k;
        } else {
            max = k;
            min = nums.length;
        }

        int gcd = min;
        if (max % min != 0) {
            while (max > 0) {
                int r = gcd % max;
                gcd = max;
                max = r;
            }
        }

        for (int j = 0; j < gcd; j++) {
            int i = j;
            int buffer = 0;
            boolean flag = true;
            do {
                int target = (i + k) % nums.length;
                int temp = nums[target];
                if (flag) {
                    flag = false;
                    nums[target] = nums[i];
                } else {
                    nums[target] = buffer;
                }
                buffer = temp;
                i = target;
            } while (i != j);
        }
    }

    public int maxProfit(int[] prices) {
        int lowPrice = prices[0];
        int profit = 0;
        for (int price : prices) {
            lowPrice = Math.min(lowPrice, price);
            profit = Math.max(profit, price - lowPrice);
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        int lowPrice = (prices.length > 0) ? prices[0] : 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += prices[i] - lowPrice;
            }
            lowPrice = prices[i];
        }
        return profit;
    }

    public boolean canJump(int[] nums) {
        int maxStep = (nums.length > 0) ? nums[0] : -1;
        int i = 1;
        while (maxStep > 0 && i < nums.length) {
            maxStep = Math.max(maxStep - 1, nums[i]);
            i++;
        }
        return i == nums.length;
    }

    public int jump(int[] nums) {
        int step = 0, maxPos = 0, maxDistance = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (i == maxPos) {
                maxPos = maxDistance;
                step++;
            }
        }
        return step;
    }

    public int hIndex(int[] citations) {
        int left = 0, mid, right = citations.length;
        while (left < right) {
            mid = (left + right + 1) / 2;
            int cnt = 0;
            for (int citation : citations) {
                if (citation >= mid) {
                    cnt++;
                }
            }
            if (cnt >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    @SuppressWarnings("all")
    public class RandomizedSet {
        private int[] nums;
        private final Map<Integer, Integer> indices;
        private int size; // 当前有效元素数量

        public RandomizedSet() {
            nums = new int[16]; // 初始容量可自行决定
            indices = new HashMap<>();
            size = 0;
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            // 如果当前数组已满，则扩容
            if (size == nums.length) {
                int[] newNums = new int[nums.length * 2];
                System.arraycopy(nums, 0, newNums, 0, size);
                nums = newNums;
            }
            nums[size] = val;
            indices.put(val, size);
            size++;
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) {
                return false;
            }
            int index = indices.get(val);
            int last = nums[size - 1];
            // 将最后一个元素放到待删除元素的位置
            nums[index] = last;
            indices.put(last, index);
            size--;
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            int randomIndex = new Random().nextInt(size);
            return nums[randomIndex];
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, 1);

        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = length - 2; i >= 0; i--) {
            R *= nums[i + 1];
            result[i] *= R;
        }
        return result;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            cost[i] = gas[i] - cost[i];
        }
        int station = -1;
        // 计算 cost[] 总和
        int total = 0;
        for (int c : cost) {
            total += c;
        }
        if (total >= 0) {
            int start = 0;
            int end;
            int power;
            while (start < length) {
                end = 0;
                power = 0;
                while (end < length) {
                    power += cost[(start + end) % length];
                    if (power < 0) {
                        start = (end == 0) ? (start + 1) : (start + end) % length;
                        break;
                    }
                    end++;
                }
                if (end == length) {
                    station = start;
                    break;
                }
            }
        }
        return station;
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int minCandy = 1;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else if (ratings[i] == ratings[i - 1]) {
                candies[i] = minCandy;
            } else {
                candies[i] = candies[i - 1] - 1;
                minCandy = Math.min(candies[i], minCandy);
            }
        }
        int y = (1 - minCandy) * n ;

        int sum = 0;
        for (int c : candies) {
            sum += c;
        }
        return sum + y;
    }

    public int trap(int[] height) {
        int sum = 0;
        int length = height.length;
        int[] right = new int[length];
        int[] left = new int[length];

        for (int i = 1; i < length - 1; i++) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
        }
        for (int i = length - 2; i > 0; i--) {
            right[i] = Math.max(height[i + 1], right[i + 1]);
        }
        for (int i = 0; i < length; i++) {
            int x = Math.min(left[i], right[i]);
            if (x > height[i]) {
                sum += x - height[i];
            }
        }
        return sum;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<>();
        symbolValues.put('I', 1);
        symbolValues.put('V', 5);
        symbolValues.put('X', 10);
        symbolValues.put('L', 50);
        symbolValues.put('C', 100);
        symbolValues.put('D', 500);
        symbolValues.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            res += symbolValues.get(s.charAt(i)) >= symbolValues.get(s.charAt(i + 1))
                    ? symbolValues.get(s.charAt(i))
                    : -symbolValues.get(s.charAt(i));
        }
        res += symbolValues.get(s.charAt(s.length() - 1));
        return res;
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    public int lengthOfLastWord(String s) {
        int result = 0;
        int length = s.length() - 1;
        while (length >= 0 && (s.charAt(length) == ' ' || s.charAt(length) == '\0')) {
            length--;
        }
        while (length >= 0 && s.charAt(length) != ' ') {
            result++;
            length--;
        }
        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//        int index = s.length() - 1;
//        while (index >= 0) {
//            while (index >=0 && s.charAt(index) == ' ') {
//                index--;
//            }
//            int wordLength = 0;
//            while (index >= 0 && s.charAt(index) != ' ') {
//                wordLength++;
//                index--;
//            }
//            sb.append(s, index  + 1, index + wordLength + 1);
//            sb.append(" ");
//        }
//        while (sb.length() - 1 >= 0 && sb.charAt(sb.length() -1) == ' ') {
//            sb.deleteCharAt(sb.length() - 1);
//        }
//        return sb.toString();
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int step = 0;
        int i = 0;
        while (i < s.length()) {
            while (step < numRows - 1 && i < s.length()) {
                stringBuilders[step].append(s.charAt(i));
                step++;
                i++;
            }
            while (step > 0 && i < s.length()) {
                stringBuilders[step].append(s.charAt(i));
                step--;
                i++;
            }
        }
        for (StringBuilder stringBuilder : stringBuilders) {
            result.append(stringBuilder.toString());
        }
        return result.toString();
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        int start = 0, end = 0;
        while (end < words.length) {
            start = end;
            int length = 0;
            while (end < words.length && length + words[end].length() + 1 < maxWidth) {
                length = length + words[end].length() + 1;
                end++;
            }
            if (end < words.length && length + words[end].length() <= maxWidth) {
                length = length + words[end].length();
                end++;
            } else {
                length -= 1;
            }
            int space = maxWidth - length + ((end - start) - 1);
            int repeat = (end - start) == 1 ? space : space / ((end - start) - 1);
            int diff = (end - start) == 1 ? 0 : space % ((end - start) - 1);
            for (int i = start; i < end; i++) {
                currentWord.append(words[i]);
                currentWord.append(" ".repeat(diff > 0 ? repeat + 1 : repeat));
                diff -= 1;
            }
            if (currentWord.length() > maxWidth) {
                currentWord.delete(maxWidth, currentWord.length());
            }
            result.add(currentWord.toString());
            currentWord.delete(0, currentWord.length());
        }
        if (end - start > 1) {
            result.removeLast();
            for (int i = start; i < end; i++) {
                currentWord.append(words[i]);
                currentWord.append(" ");
            }
            if (currentWord.length() > maxWidth) {
                currentWord.delete(maxWidth, currentWord.length());
            } else {
                currentWord.append(" ".repeat(maxWidth - currentWord.length()));
            }
            result.add(currentWord.toString());
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left != right) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left != right) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }

        }
        return true;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{left + 1, right + 1};
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxSize = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            maxSize = Math.max(maxSize, Math.min(height[left], height[right]) * (right - left));
        }
        return maxSize;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; nums[i] <= 0 && i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 去重
                    while (left < right && nums[right] == nums[right - 1]) right--; // 去重
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return result;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, longest = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            longest = Math.max(longest, set.size());
        }
        return longest;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> reference = new HashMap<>();
        for (String word : words) {
            reference.put(word, reference.getOrDefault(word, 0) + 1);
        }
        int wordLength = words[0].length();

        if (wordLength * words.length <= s.length()) {
            HashMap<String, Integer> windows = new HashMap<>(words.length);
            for (int i = 0; i < wordLength; i++) {
                int start = i, end = i;

                for (int time = 0; time < words.length && end + wordLength <= s.length(); time++, end += wordLength) {
                    String next = s.substring(end, end + wordLength);
                    windows.put(next, windows.getOrDefault(next, 0) + 1);
                }

                if (windows.equals(reference)) {
                    result.add(start);
                }
                if (end + wordLength > s.length()) {
                    windows.clear();
                    continue;
                }
                while (end + wordLength <= s.length()) {
                    String first = s.substring(start, start + wordLength);
                    windows.replace(first, windows.get(first) - 1);
                    if (windows.get(first) <= 0) {
                        windows.remove(first);
                    }
                    start += wordLength;

                    String next = s.substring(end, end + wordLength);
                    windows.put(next, windows.getOrDefault(next, 0) + 1);
                    end += wordLength;

                    if (windows.equals(reference)) {
                        result.add(start);
                    }
                }
                windows.clear();
            }

        }
        return result;
    }

    public String minWindow(String s, String t) {
        int[] result = {-1, s.length()};

        HashMap<Character, Integer> count = new HashMap<>();
        for (Character letter : t.toCharArray()) {
            count.put(letter, count.getOrDefault(letter, 0) + 1);
        }
        int lack = count.size();

        int left = 0, right = 0;
        while (right < s.length()) {
            Character letter = s.charAt(right);
            count.put(letter, count.getOrDefault(letter, 0) - 1);
            if (count.getOrDefault(letter, 0) == 0) {
                lack -= 1;
            }
            while (lack == 0) {
                if (right - left < result[1] - result[0]) {
                    result[0] = left;
                    result[1] = right;
                }
                letter = s.charAt(left);
                if (count.getOrDefault(letter, 0) == 0) {
                    lack++;
                }
                count.put(letter, count.getOrDefault(letter, 0) + 1);
                left++;
            }

            right++;
        }
        return result[0] < 0 ? "" : s.substring(result[0], result[1] + 1);
    }

    public boolean isValidSudoku(char[][] board) {
        boolean flag = true;
        ArrayList<HashSet<Character>> block = new ArrayList<>(19);
        for (int i = 0; i < 19; i++) {
            block.add(i, new HashSet<>());
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int label = row / 3 + col / 3 * 3;
                char c = board[row][col];
                if (c == '.') {
                    continue;
                }
                if (block.get(18).contains(c) || block.get(label).contains(c) || block.get(9 + col).contains(c)) {
                    flag = false;
                    break;
                }
                block.get(18).add(c);
                block.get(label).add(c);
                block.get(9 + col).add(c);
            }
            block.get(18).clear();
            if (!flag) {
                break;
            }
        }
        return flag;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int L = 0, R = n, T = 0, B = m, i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        while (L < R && T < B) {
            while (i < R) res.add(matrix[j][i++]);
            T++;
            i--;
            j++;
            while (j < B) res.add(matrix[j++][i]);
            R--;
            i--;
            j--;
            while (i >= L && res.size() < m * n) res.add(matrix[j][i--]);
            B--;
            i++;
            j--;
            while (j >= T && res.size() < m * n) res.add(matrix[j--][i]);
            L++;
            i++;
            j++;
        }
        return res;
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = temp;
            }
        }
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = temp;

            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int zeroRowFlag = -1;
        int zeroColFlag = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRowFlag = i;
                    zeroColFlag = j;
                    break;
                }
            }
        }

        if (zeroRowFlag >= 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][zeroColFlag] = matrix[i][zeroColFlag] == 0 ? 1 : 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[zeroRowFlag][i] = matrix[zeroRowFlag][i] == 0 ? 1 : 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                if (i == zeroRowFlag) continue;
                for (int j = 0; j < matrix[0].length; j++) {
                    if (j == zeroColFlag) continue;
                    if (matrix[i][j] == 0) {
                        matrix[zeroRowFlag][j] = 1;
                        matrix[i][zeroColFlag] = 1;
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                if (i == zeroRowFlag) continue;
                if (matrix[i][zeroColFlag] == 1) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == zeroColFlag) continue;
                if (matrix[zeroRowFlag][j] == 1) {
                    for (int i = 0; i < matrix.length; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[zeroRowFlag][j] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][zeroColFlag] = 0;
            }
        }
    }

    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = -1;
                }
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 2;
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        boolean result = true;
        HashMap<Character, Integer> reference = new HashMap<>(magazine.length());
        for (int i = 0; i < magazine.length(); i++) {
            char letter = magazine.charAt(i);
            reference.put(letter, reference.getOrDefault(letter, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char letter = ransomNote.charAt(i);
            if (reference.containsKey(letter)) {
                reference.replace(letter, reference.get(letter) - 1);
                if (reference.get(letter) < 0) {
                    result = false;
                    break;
                }
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char letter1 = s.charAt(i);
            char letter2 = t.charAt(i);
            if (!map.containsKey(letter1)) {
                if (map.containsValue(letter2)) {
                    return false;
                }
                map.put(letter1, letter2);
            } else {
                if (!map.get(letter1).equals(letter2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>(s.length());
        String[] words = s.split("\\s+");

        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(s.charAt(i), words[i]);
            } else {
                if (!map.get(s.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char letter1 = s.charAt(i);
            map.put(letter1, map.getOrDefault(letter1, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char letter2 = t.charAt(i);
            if (!map.containsKey(letter2)) {
                return false;
            } else {
                map.replace(letter2, map.get(letter2) - 1);
                if (map.get(letter2) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] letter = new int[26];
        StringBuilder sb = new StringBuilder();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] word = str.toCharArray();
            for (char c : word) {
                letter[c - 'a'] += 1;
            }
            for (int i = 0; i < letter.length; i++) {
                while (letter[i] > 0) {
                    sb.append(Character.toChars('a' + i));
                    letter[i]--;
                }
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), new ArrayList<>()));
            map.get(sb.toString()).add(str);
            sb.delete(0, sb.length());
        }
        List<List<String>> result = new ArrayList<>();
        for (String str : map.keySet()) {
            result.add(map.get(str));
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (diff.containsKey(target - nums[i])) {
                result[0] = diff.get(target - nums[i]);
                result[1] = i;
            } else {
                diff.put(nums[i], i);
            }
        }

        return result;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int sum = n;
        while (sum != 1 && !set.contains(sum)) {
            set.add(sum);
            char[] nums = Integer.toString(sum).toCharArray();
            sum = 0;
            for (char num : nums) {
                sum += (int) Math.pow(num - '0', 2);
            }

        }
        return sum == 1;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int longestSize = 0;
        int size = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                size = 1;
                while (set.contains(num + 1)) {
                    size++;
                    num++;
                }
            }
            longestSize = Math.max(longestSize, size);
        }
        return longestSize;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>(nums.length);
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0, end = 0;
        while (end < nums.length) {
            while (end + 1 < nums.length && nums[end] + 1 == nums[end + 1]) {
                end++;
            }
            if (end > start) {
                stringBuilder.append(nums[start]).append("->").append(nums[end]);
            } else {
                stringBuilder.append(nums[start]);
            }
            result.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
            start = end + 1;
            end = start;
        }
        return result;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i + 1 < intervals.length && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[0] > end) {
                if (!placed) {
                    ansList.add(new int[]{start, end});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < start) {
                ansList.add(interval);
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{start, end});
        }
        return ansList.toArray(new int[ansList.size()][2]);
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length < 1) return points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int num = 1;
        int[] center = points[0];
        for(int i = 1; i < points.length; i++){
            if ((center[0] < points[i][0] && center[1] < points[i][0]) || (points[i][1] < center[0] && points[i][0] < center[0])){
                center = points[i];
                num++;
            }else {
                center[0] = Math.max(center[0],points[i][0]);
                center[1] = Math.min(center[1],points[i][1]);
            }
        }
        return num;
    }

}

