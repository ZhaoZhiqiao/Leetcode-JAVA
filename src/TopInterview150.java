import java.util.*;

public class TopInterview150 {

    public static void main(String[] args) {
        TopInterview150 solution = new TopInterview150();
        int[] list1 = {1,2,3,4,5};
        int[] list2 = {3, 4, 5, 1, 2, 0, 0, 0};
        int n = 11;
        int m = 2;
        int k = 3;
        String str1 = "abc";
        String str2 = "ahbgdc";
        String[] strings = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
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
//        list2 = solution.twoSum(list1, n);
//        System.out.println(solution.maxArea(list1));
//        System.out.println(solution.threeSum(list1));
        System.out.println(solution.minSubArrayLen(n, list1));

        //-----------------------------test--------------------------------------------
        System.out.print("list 1:  ");
        for (int i : list1) {
            System.out.print(i + " ");
        }
        System.out.print("\nlist 2:  ");
        for (int i : list2) {
            System.out.print(i + " ");
        }
        System.out.print("\nn: " + n + "\nm: " + m + "\nk: " + k);
        //-----------------------------------------------------------------------------
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
        int left = 0, mid = 0, right = citations.length;
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

    // 将 RandomizedSet 中的 List<Integer> 改为 int[] （需自行管理 size）
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
        int y = (minCandy <= 1 ? (1 - minCandy) * n : minCandy);

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
        int result = haystack.indexOf(needle);
        return result;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
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

    public int[] twoSum(int[] numbers, int target) {
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
        int minWindowLength;
        boolean found = false;
        for (minWindowLength = 1; minWindowLength <= target; minWindowLength++) {
            for (int i = 0; i <= nums.length - minWindowLength; i++) {
                int sum = 0;
                for (int j = i; j < i + minWindowLength; j++) {
                    sum += nums[j];
                }
                if (sum >= target) {
                    found = true;
                    break;
                }
            }
            if (found) {break;}
        }
        return found ? minWindowLength : 0;
    }
}

