import tree.TreeNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AliyunDemo {

    public static void main(String[] args) {
        // System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        // System.out.println(solution(new int[][]{{4,1,5,3}, {3,2, 7,7 },{6,5, 2,8},{8,9,4,5}}));

        // System.out.println(muliArr(5, 2, new int[]{1,1,2,2,4}));

        System.out.println(mySqrt2(2147395599));
    }

    // leetcode 69 x 的平方根
    public static int mySqrt(int x) {
        int start = 0, end = x, ans = 0;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if ((long)mid * mid > x){
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    public static double mySqrt2(int x) {
        int precision = 2;
        double lower = 0;
        double high = x;
        double mid;
        double threshold = Math.pow(10, -precision);
        do {
            mid = lower + (high - lower) / 2;
            if (mid * mid > x) {
                high = mid;
            } else {
                lower = mid;
            }

        } while (Math.abs(mid * mid - x) > threshold);

        return new BigDecimal(mid).setScale(precision, BigDecimal.ROUND_DOWN).doubleValue();
    }

    public static int solution(int[][] m) {
        return solution(m, 0, 0);
    }

    public static int solution(int[][] m, int i, int j) {
        if (i == m.length - 1 && j == m[i].length - 1){
            return m[i][j];
        }
        if (i == m.length - 1){
            return m[i][j] + solution(m, i, j + 1);
        }
        if (j == m[i].length - 1){
            return m[i][j] + solution(m, i + 1, j);
        }
        return m[i][j] + Math.min(solution(m, i + 1, j), solution(m, i, j + 1));
    }

    // 连续数列
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;

    }

    public int solution(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        preOrder(root, vals);
        return vals.get(1);
    }

    public void preOrder(TreeNode node, List<Integer> vals) {
        if (null == node){
            return;
        }
        preOrder(node.right, vals);
        vals.add(node.val);
        preOrder(node.left, vals);

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 等比数列
     * O(n * n * n) 三次方
     */
    public static long muliArr(int n, int k, int[] array) {
        int count = 0;
        for (int i = array.length - 1; i >= 0; i--){
            int l3 = array[i];
            if (l3 % k != 0){
                 continue;
            }
            for (int j = i - 1; j >= 0; j--){
                int l2 = array[j];
                if (l2 != l3 / k){
                    continue;
                }
                int m = j - 1;
                while (m >= 0){
                    if (array[m] == l2 / k){
                        count++;
                    }
                    m--;
                }
            }
        }
        return count;
    }

}
