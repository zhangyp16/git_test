package niuke;

import java.util.*;

public class NiuKeDemo {

    public static void main(String[] args) {
        reConstructBinaryTree(new int[]{1,2,3,4,5,6,7},new int[]{3,2,4,1,6,5,7});
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

}
