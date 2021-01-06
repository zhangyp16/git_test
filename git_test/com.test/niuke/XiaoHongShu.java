package niuke;

import java.util.LinkedList;
import java.util.Queue;

public class XiaoHongShu {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        System.out.println(isSymmetric(root));
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

}
