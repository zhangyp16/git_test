package niuke;

import java.util.*;

public class NiuKeDemo {

    public static void main(String[] args) {
        // reConstructBinaryTree(new int[]{1,2,3,4,5,6,7},new int[]{3,2,4,1,6,5,7});
        Fibonacci(4);
    }


    // 1、NC66 两个链表的第一个公共结点



    // 2、NC78 反转链表
    public static ListNode ReverseList(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode cur = head;
        while (null != cur){
            vals.add(0, cur.val);
            cur = cur.next;
        }
        cur = head;
        for (Integer val : vals){
            cur.val = val;
            cur = cur.next;
        }
        return head;

    }



    public static ListNode ReverseList2(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // NC4 判断链表中是否有环
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        fast = slow = head;
        return false;

    }


    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> invals = new ArrayList<>();
        order(root, invals, 1);
        List<Integer> prevals = new ArrayList<>();
        order(root, prevals, 2);
        List<Integer> lastvals = new ArrayList<>();
        order(root, lastvals, 3);

        int[][] ret = new int[3][];
        ret[0] = transfer(invals);
        ret[1] = transfer(prevals);
        ret[2] = transfer(lastvals);
        return ret;
    }

    private int[] transfer(List<Integer> vals){
        int[] ret = new int[vals.size()];
        for (int i = 0; i < vals.size(); i++){
            ret[i] = vals.get(i);
        }
        return ret;
    }

    private void order(TreeNode node, List<Integer> vals, int type){
        if(null == node){
            return;
        }
        if (1 == type){
            vals.add(node.val);
        }
        order(node.left, vals, type);
        if (2 == type){
            vals.add(node.val);
        }
        order(node.right, vals, type);
        if (3 == type){
            vals.add(node.val);
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return Math.abs(high(root.left) - high(root.right)) <= 1
                && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int high(TreeNode node){
        if(null == node){
            return 0;
        }
        return Math.max(high(node.left), high(node.right)) + 1;
    }


    // [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
    // Arrays.copyOfRange
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //数组长度为0的时候要处理
        if(pre.length == 0){
            return null;
        }

        int rootVal = pre[0];

        //数组长度仅为1的时候就要处理
        if(pre.length == 1){
            return new TreeNode(rootVal);
        }

        //我们先找到root所在的位置，确定好前序和中序中左子树和右子树序列的范围
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for(int i=0;i<in.length;i++){
            if(rootVal == in[i]){
                rootIndex = i;
                break;
            }
        }

        //递归，假设root的左右子树都已经构建完毕，那么只要将左右子树安到root左右即可
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),
                Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length),
                Arrays.copyOfRange(in,rootIndex+1,in.length));
        return root;
    }

    public static int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int pre = 0, cur = 1;
        for (int i = 2; i <= n; i++){
            int tmp = cur;
            cur = pre + cur;
            pre = tmp;
        }
        return cur;
    }

    /*public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        List<Integer> list = new ArrayList<>();
        while (null != l1){
            list.add(l1.val);
            l1 = l1.next;
        }
        while (null != l2){
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        ListNode
        return ret;
    }*/



    /**
     * NC 21 链表内指定区间反转  时间复杂度 ，空间复杂度
     * @param head ListNode类
     * @param m int整型  1≤m≤n≤链表长度
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        int idx = 0;
        while (idx < n){

            idx++;
        }
        return head;
    }
}
