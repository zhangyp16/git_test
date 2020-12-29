package niuke;

import java.util.*;

public class ArrayDemo {

    public static void main(String[] args) {
        // System.out.println(findKth(new int[]{1,3,5,2,2},5,3));
        // System.out.println(JumpFloor(5));
        // System.out.println(upper_bound_(6, 4, new int[]{1,2,4,4,5, 8}));
        System.out.println(maxLength(new int[]{2,3,4,5}));
    }


    public static int findKth(int[] a, int n, int K) {
        a = Arrays.stream(a).sorted().toArray();
        return a[n - K];
    }

    public static int JumpFloor(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int med = n / 2;
        while (med > 0){
            if (a[med] == v){
                while (a[med - 1] == v){
                    med--;
                }
                return ++med;
            }
            if (a[med] > v){
                med = (med + n) / 2;
            }
            if (a[med] < v){
                med = med / 2;
            }
        }
        return n + 1;
    }


    public static int maxLength (int[] arr) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        int start = 0;
        while (start < arr.length){
            int tmp = start;
            while (tmp < arr.length && set.add(arr[tmp])){
                tmp++;
            }
            max = Math.max(max, set.size());
            set.clear();
            start++;
        }
        return max;
    }
}
