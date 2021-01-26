package tree;

import java.util.*;

public class TreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    //DFS递归写法
    public int maxDepthDFS(Node root) {
        if(root == null)
            return 0;
        int depth = 0;
        for(int i = 0;i<root.children.size();i++){
            depth = Math.max(depth,maxDepth(root.children.get(i)));
        }
        return depth+1;
    }

    //层序遍历解法
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        if(root.children.size() == 0)
            return 1;
        int depth = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            depth++;
            while(count > 0){
                Node node = queue.poll();
                if(node.children.size() != 0)
                    queue.addAll(node.children);
                count--;
            }
        }
        return depth;
    }


    // 中序遍历
    private void inorder(TreeNode root, List<Integer> vals){
        if (null == root){
            return;
        }
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }

    // 前序遍历
    private void preorder(TreeNode root, List<Integer> vals){
        if (null == root){
            return;
        }
        vals.add(root.val);
        preorder(root.left, vals);
        preorder(root.right, vals);
    }

    // 后序遍历
    private void lastorder(TreeNode root, List<Integer> vals){
        if (null == root){
            return;
        }
        lastorder(root.left, vals);
        lastorder(root.right, vals);
        vals.add(root.val);
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    // 690 员工的重要性
    public int getImportance(List<Employee> employees, int id) {
        int count = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees){
            map.put(employee.id, employee);
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                Employee employee = queue.poll();
                if (null != employee){
                    count += employee.importance;
                    for (int i = 0; i < employee.subordinates.size(); i++){
                        queue.add(map.get(employee.subordinates.get(i)));
                    }
                }
                size--;
            }
        }
        return count;
    }

    // 993. 二叉树的堂兄弟节点
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();

                size--;
            }
        }
        return false;
    }

    // 563. 二叉树的坡度
    public int findTilt(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        countNodeTilt(root, vals);

        int count = 0;
        for (Integer t : vals){
            count += t;
        }
        return count;
    }

    public void countNodeTilt(TreeNode node, List<Integer> vals) {
        if (null == node){
            return;
        }
        vals.add(Math.abs(sumNode(node.left) - sumNode(node.right)));
        countNodeTilt(node.left, vals);
        countNodeTilt(node.right, vals);
    }

    public int sumNode(TreeNode node) {
        if (null == node){
            return 0;
        }
        return node.val + sumNode(node.left) + sumNode(node.right);
    }

    public boolean isBalanced(TreeNode root) {
        if (null == root || Math.abs(high(root.left) - high(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int high(TreeNode node){
        if(null == node){
            return 0;
        }
        return Math.max(high(node.left), high(node.right)) + 1;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> vals = new ArrayList<>();
        if (null == root){
            return vals;
        }
        if (null == root.left && null == root.right){
            vals.add(root.val + "");
            return vals;
        }

        if (null != root.left){
            List<String> leftStr = binaryTreePaths(root.left);
            for (String left : leftStr) {
                vals.add(root.val + "->" + left);
            }
        }
        if (null != root.right){
            List<String> rightStr = binaryTreePaths(root.right);
            for (String right : rightStr) {
                vals.add(root.val + "->" + right);
            }
        }
        return vals;
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTreeNode(nums, 0, nums.length);
    }

    private static TreeNode buildTreeNode(int[] nums, int start, int end){
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if(mid <= 0 || mid >= end){
            return node;
        }

        node.left = buildTreeNode(nums, start, mid);
        node.right = buildTreeNode(nums, mid, end);
        return node;
    }


    // 3、NC15 求二叉树的层序遍历
    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            ArrayList<Integer> vals = new ArrayList<>();
            while (count > 0){
                TreeNode node = queue.poll();
                vals.add(node.val);
                if (null != node.left){
                    queue.add(node.left);
                }
                if (null != node.right){
                    queue.add(node.right);
                }
                count--;
            }
            ret.add(vals);
        }
        return ret;
    }

    // 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return root;
    }

    private void lastOrder(TreeNode node, TreeNode p, TreeNode q){

    }

    private boolean hasNode(TreeNode node, TreeNode p){
        return node.val == p.val || hasNode(node.left, p) || hasNode(node.right, p);
    }
}
