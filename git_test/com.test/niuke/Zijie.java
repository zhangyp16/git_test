package niuke;

import java.util.*;

public class Zijie {

    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }

    /**
     * NC 22 数组 + 双指针
     * 给出两个有序的整数数组 A和B ，请将数组 B合并到数组 A中，变成一个有序的数组
     * 注意：
     * 可以假设 A数组有足够的空间存放 B数组的元素， A和 B中初始的元素数目分别为 m和n
     */
    public void merge(int A[], int m, int B[], int n) {
        if (m == 0 || n == 0){
            return;
        }
        int first = 0, second = 0;
        Queue<Integer> queue = new LinkedList<>();
        while (first < m && second < n){
            if (first < m - 1 && second < n - 1){
                if (A[first] < B[second]){
                    queue.add(A[first]);
                    first++;
                } else {
                    queue.add(B[second]);
                    second++;
                }
            }
            if (first == m - 1){
                queue.add(B[second]);
                second++;
            }
            if (second == n - 1){
                queue.add(A[first]);
                first++;
            }


        }
        for (int i = m + n - 1; i >= 0; i--){
            A[i] = queue.poll();
        }

    }

    public void merge2(int A[], int aIdx, int B[], int bIdx) {
        if (A[aIdx] > B[bIdx]){

            int tmp = A[aIdx];
            A[aIdx] = B[bIdx];
            B[bIdx] = tmp;

            merge(A, ++aIdx, B, bIdx);
        } else {
            merge(A, ++aIdx, B, bIdx);
        }
    }

    /**
     * 剑指 offer 25 & leetcode 21
     * 合并两个排序的链表  两个递增排序的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1){
            return l2;
        }
        if (null == l2){
            return l1;
        }
        ListNode node = null;
        if (l1.val < l2.val){
            node = new ListNode(l1.val);
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            node = new ListNode(l2.val);
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }


    /**
     * 树的直径
     * @param n int整型 树的节点个数
     * @param Tree_edge Interval类一维数组 树的边
     * @param Edge_value int整型一维数组 边的权值
     * @return int整型
     */
    public int solve (int n, Interval[] Tree_edge, int[] Edge_value) {

        // write code here
        return 0;
    }

    public static class Interval {
        int start;
        int end;
     }

    // NC 52  合法的括号 序列
    public static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        // write code here
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()){
                    return false;
                }
                if (s.charAt(i) == ')' && stack.pop() != '('){
                    return false;
                } else if (s.charAt(i) == ']' && stack.pop() != '['){
                    return false;
                } else if (s.charAt(i) == '}' && stack.pop() != '{'){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /**
     * NC 7 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
     * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++){
            for (int j = i; j < prices.length; j++){
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        // write code here
        return max;
    }

    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        if (null == root){
            return false;
        }
        if (null == root.left && null == root.right && root.val == sum){
            return true;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

}
