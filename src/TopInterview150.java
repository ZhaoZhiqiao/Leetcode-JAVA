import java.util.*;

public class TopInterview150 {

    public static void main(String[] args) {
        int[] list1 = {0, 1, 0, 2, 0, 0, 0, 0};
        int[] list2 = {3, 4, 5, 1, 2, 0, 0, 0};
        int n = 9;
        int m = 2;
        int k = 3;
        String str1 = "IX";

//        merge(list1, 3, list2, 3);
//        System.out.println(removeElement(list1, m));
//        System.out.println(removeDuplicates(list1));
//        System.out.println(removeDuplicates2(list1));
//        System.out.println(majorityElement(list1));
//        rotate(list1, k);
//        System.out.println(maxProfit(list1));
//        System.out.println(maxProfit2(list1));
//        System.out.println(canJump(list1));
//        System.out.println(jump(list1));
//        System.out.println(hIndex(list1));
//        list2 = productExceptSelf(list1);
//        System.out.println(canCompleteCircuit(list1, list2));
//        System.out.println(candy(list1));
//        System.out.println(trap(list1));
//        System.out.println(romanToInt(str1));
//        System.out.println(intToRoman(n));
//        System.out.println(lengthOfLastWord(str1));

        //-----------------------------test--------------------------------------------
        System.out.print("list 1:  ");
        for (int i : list1) {
            System.out.print(i + " ");
        }
        System.out.println("\nlist 2:  ");
        for (int i : list2) {
            System.out.print(i + " ");
        }
        System.out.println("\nn: " + n + "  m: " + m + "  k: " + k);
        //-----------------------------------------------------------------------------
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
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

    public static int removeElement(int[] nums, int val) {
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

    public static int removeDuplicates(int[] nums) {
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

    public static int removeDuplicates2(int[] nums) {
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

    public static int majorityElement(int[] nums) {
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

    public static void rotate(int[] nums, int k) {
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

    public static int maxProfit(int[] prices) {
        int lowPrice = prices[0];
        int profit = 0;
        for (int price : prices) {
            lowPrice = Math.min(lowPrice, price);
            profit = Math.max(profit, price - lowPrice);
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {
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

    public static boolean canJump(int[] nums) {
        int maxStep = (nums.length > 0) ? nums[0] : -1;
        int i = 1;
        while (maxStep > 0 && i < nums.length) {
            maxStep = Math.max(maxStep - 1, nums[i]);
            i++;
        }
        return i == nums.length;
    }

    public static int jump(int[] nums) {
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

    public static int hIndex(int[] citations) {
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
    public static class RandomizedSet {
        private int[] nums;
        private Map<Integer, Integer> indices;
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

    public static int[] productExceptSelf(int[] nums) {
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

    public static int canCompleteCircuit(int[] gas, int[] cost) {
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
            int end = 0;
            int power = 0;
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

    public static int candy(int[] ratings) {
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

    public static int trap(int[] height) {
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

    public static int romanToInt(String s) {
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

    public static String intToRoman(int num) {
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

    public static int lengthOfLastWord(String s) {
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
}
