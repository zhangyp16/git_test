package array;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayDemo {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("haha", "lala"));
        System.out.println(map.put("haha", "kaka"));
        System.out.println(map.get("haha"));
        // System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1,0,1}));

        // System.out.println(maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }


    // 485. 给定一个二进制数组， 计算其中最大连续1的个数

    public static int findMaxConsecutiveOnes(int[] nums) {
        int start = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                max = Math.max(max, (i - start - 1));
                start = i;
            } else {
                max = Math.max(max, (i - start));
            }
        }
        return max;
    }

    // 495
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int length = timeSeries.length;


        return 0;
    }
    // 414、628


    // 给定一个整数数组，找出总和最大的连续数列，并返回总和
    public int maxSubArray(int[] nums) {
        return 0;
    }

    // 556 下一个更大元素 III
    public int nextGreaterElement(int n) {
        return -1;
    }

    // 滑动窗口最大值
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return nums;
        }
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++){
            int max = nums[i];
            for (int j = i; j < i + k; j++){
                max = Math.max(max, nums[j]);
            }
            ret[i] = max;
        }
        return ret;
    }

    // 滑动窗口 - 单调队列解法
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        //#1
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            //#2
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);

            //#3
            if (queue.peekFirst() <= (i - k)) {//如果被窗口抛下了（在窗口左边界的左侧）
                queue.pollFirst();
            }
            if (i >= k - 1) {
                result[index++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }

    class RecentCounter {

        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (!queue.isEmpty()){
                if (queue.peek() >= t - 3000){
                    break;
                }
                queue.poll();
            }

            return queue.size();
        }
    }

}
