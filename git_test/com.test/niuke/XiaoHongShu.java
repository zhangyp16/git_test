package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class XiaoHongShu {

    public static void main(String[] args) {

        System.out.println(solve(23, 12));
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

}
