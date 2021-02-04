package array;

import java.util.Arrays;

public class TwoPointerDemo {

    public static void main(String[] args) {
        // System.out.println(isPalindrome("OP"));
        // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3

        // merge(new int[]{4,5,6,0,0,0}, 3, new int[]{1,2,3}, 3);

        // System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

        System.out.println(findMaxAverage(new int[]{0,4,0,3,2}, 1));
    }

    public static boolean isPalindrome(String s) {
        if (null == s){
            return true;
        }
        int low = 0, high = s.length() - 1;
        while (low < high){
            while (low < high && !Character.isLetterOrDigit(s.charAt(low))){
                low++;
            }
            while (low > high && !Character.isLetterOrDigit(s.charAt(low))){
                high--;
            }
            if (low < high) {
                if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                    return false;
                }
                ++low;
                --high;
            }
        }
        return true;
    }

    // leet-code 88 合并两个有序数组
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }
        int idx_1 = m - 1, idx_2 = n - 1;
        int last = m + n - 1;

        if (m == 0){
            nums1[last] = nums2[idx_2];
            merge(nums1, 0, nums2, n - 1);
            return;
        }

        if (nums1[idx_1] >= nums2[idx_2]){
            nums1[last] = nums1[idx_1];
            // nums1[idx_1] = Integer.MIN_VALUE;
            merge(nums1, m - 1, nums2, n);
        } else {
            nums1[last] = nums2[idx_2];
            merge(nums1, m, nums2, n - 1);
        }
    }

    // leetcode 26. 删除排序数组中的重复项
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return len;
        }
        int slow = 0, fast = slow + 1;
        while (fast < len){
            if (nums[slow] == nums[fast]){
                fast++;
            } else {
                nums[slow + 1] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }

    // 977. 有序数组的平方
    public int[] sortedSquares(int[] nums) {
        // 暴力
        /*for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);*/

        // TODO: 2021/2/2  复杂度为 O(n) 的算法
        int x1 = 0, x2 = 0;
        return nums;
    }

    // leet-code 350 两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
        return new int[0];
    }

    // 480. 滑动窗口中位数
    public double[] medianSlidingWindow(int[] nums, int k) {
        return new double[0];
    }

    // 643. 子数组最大平均数 I
    public static double findMaxAverage(int[] nums, int k) {
        double max = 0;
        for (int i = 0; i < k; i++){
            max += nums[i];
        }
        double range = max;
        for (int i = k; i < nums.length; i++){
            range = range + nums[i] - nums[i - k];
            max = Math.max(max, range);
        }
        return max / k;
    }
}
