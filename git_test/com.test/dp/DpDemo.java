package dp;

import java.util.Arrays;

public class DpDemo {
    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[]{0,0,1,1}));
    }


    // 746. 使用最小花费爬楼梯
    public static int minCostClimbingStairs(int[] cost) {
        int[] min = new int[cost.length];
        Arrays.fill(min, -1);
        min[0] = 0;
        min[1] = Math.min(cost[0], cost[1]);


        for (int i = cost.length - 1; i >= 0; i--){
            // min[i] = Math.min(min[0])
        }
        return minCostClimbingStairs(cost, cost.length, new int[cost.length]);
    }

    // 递归
    public static int minCostClimbingStairs(int[] cost, int cur, int[] min) {
        if (min[cur - 1] >= 0){
            return min[cur - 1];
        }
        min[cur - 1] = Math.min(cost[cur - 1] + min[cur - 1], cost[cur - 2] + min[cur - 2]);


        min[cur - 1] =  Math.min(cost[cur - 1] + minCostClimbingStairs(cost, cur - 1, min),
                cost[cur - 2] + minCostClimbingStairs(cost, cur - 2, min));
        return min[cur - 1];
    }

    public void fillMin(int[] cost, int idx, int[] min) {
        if (min[idx] >= 0){
            return;
        }

    }

}
