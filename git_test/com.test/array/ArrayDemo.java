package array;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayDemo {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1,0,1}));
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
}
