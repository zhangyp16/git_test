package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class XiaoHongShu {

    public static void main(String[] args) {

        // System.out.println(mergeTwoLists(new ListNode(2), new ListNode(3)));
        System.out.println(returnInt());
    }

    private static int returnInt(){
        try {
            return 1 / 0;
        } catch (Exception e){
            return 2;
        } finally {
            return 3;
        }
    }

    // NC16
    // 给定一棵二叉树，判断琪是否是自身的镜像（即：是否对称）希望你可以用递归和迭代两种方法解决这个问题
    public static boolean isSymmetric (TreeNode root) {
        // 递归
        return checkSymmetric(root, root);
    }

    // 迭代
    public boolean isSymmetric2(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;

            q.offer(left.left);
            q.offer(right.right);

            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }

    // 递归
    private static boolean checkSymmetric(TreeNode x, TreeNode y){
        if (null == x && null == y){
            return true;
        }
        if (null == x || null == y){
            return false;
        }
        return x.val == y.val
                && checkSymmetric(x.left, y.right)
                && checkSymmetric(x.right, y.left);
    }


    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public static String solve (int M, int N) {
        List<Integer> vals = new ArrayList<>();
        int next = Math.abs(M);
        while (next > 0){
            vals.add(0, next % N);
            next = next / N;
        }
        StringBuilder sb = new StringBuilder();
        if (M < 0){
            sb.append("-");
        }
        for (Integer val : vals) {
            if (val == 15) {
                sb.append("F");
            } else if (val == 14) {
                sb.append("E");
            } else if (val == 13) {
                sb.append("D");
            } else if (val == 12) {
                sb.append("C");
            } else if (val == 11) {
                sb.append("B");
            } else if (val == 10) {
                sb.append("A");
            } else {
                sb.append(val);
            }
        }
        return sb.toString();
    }


    // NC 33 合并两个有序链表
    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {

        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while(l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return ans.next;
    }

    public ListNode mergeTwoLists2 (ListNode l1, ListNode l2) {
        // write code here
        if (null == l1 && null == l2){
            return null;
        }
        if (null == l1){
            return l2;
        }
        if (null == l2){
            return l1;
        }

        ListNode node;
        if (l1.val > l2.val){
            node = l2;
            node.next = mergeTwoLists2(l1, l2.next);
        } else {
            node = l1;
            node.next = mergeTwoLists2(l1.next, l2);
        }
        return node;
    }

    // NC 66 两个链表的第一个公共节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (null == pHead1 || null == pHead2){
            return null;
        }
        if (isCommonNode(pHead1, pHead2)){
            return pHead1;
        }
        ListNode node;
        node = FindFirstCommonNode(pHead1, pHead2.next);
        if (null != node){
            return node;
        }
        node = FindFirstCommonNode(pHead1.next, pHead2);
        if (null != node){
            return node;
        }
        node = FindFirstCommonNode(pHead1.next, pHead2.next);
        return node;
    }

    private boolean isCommonNode(ListNode pHead1, ListNode pHead2) {
        return pHead1.val == pHead2.val && isCommonNode(pHead1.next, pHead2.next);
    }
}
