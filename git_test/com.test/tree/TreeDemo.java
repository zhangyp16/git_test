package tree;

import java.util.*;

public class TreeDemo {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(6);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next = new ListNode(6);
        System.out.println(reverseList(root));
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


    // 二叉树的之字形层序遍历
    // TODO: 2021/2/7
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        while (!deque.isEmpty()){
            int count = deque.size();
            while (count > 0){
                
            }
        }
        return ret;
    }

    // leet-code 129. 求根到叶子节点数字之和
    public static int sumNumbers(TreeNode root) {
        if (null == root){
            return 0;
        }
        List<Integer> vals = new ArrayList<>();
        sumNumbers(root, 0, vals);
        int ret = 0;
        for (Integer val : vals){
            ret += val;
        }
        return ret;
    }

    public static void sumNumbers(TreeNode node, int val, List<Integer> vals) {
        if (null == node){
            return;
        }
        if (null == node.left && null == node.right){
            vals.add(Integer.parseInt(String.valueOf(val) + node.val));
            return;
        }

        if (null != node.left){
            sumNumbers(node.left, Integer.parseInt(String.valueOf(val) + node.val), vals);
        }
        if (null != node.right){
            sumNumbers(node.right, Integer.parseInt(String.valueOf(val) + node.val), vals);
        }
    }

    // 113. 路径总和 II
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, ret, new ArrayList<>(), targetSum);
        return ret;
    }

    private void dfs(TreeNode node, List<List<Integer>> ret, List<Integer> list, int val){
        if (null == node){
            return;
        }

        list.add(node.val);
        if (null == node.left
                && null == node.right
                && (val - node.val) == 0){
            ret.add(list);
            return;
        }
        dfs(node.left, ret, new ArrayList<>(list), val - node.val);
        dfs(node.right, ret, new ArrayList<>(list), val - node.val);
    }

    // 删除链表中等于给定值 val 的所有节点
    public static ListNode removeElements(ListNode head, int val) {
        if(null == head){
            return null;
        }
        if (head.val == val){
            head = removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
        }
        return head;
    }

    // 反转链表
    public static ListNode reverseList(ListNode head) {
        if (null == head){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (null != cur){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    // 反向打印
    public int[] reversePrint(ListNode head) {
        Deque<Integer> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null){
            queue.addFirst(cur.val);
            cur = cur.next;
        }
        int[] ret = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()){
            ret[i] = queue.pollFirst();
            i++;
        }
        return ret;
    }

    // 160 相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ret = null;
        Stack<ListNode> stackA = new Stack<>();
        while (headA != null){
            stackA.push(headA);
            headA = headA.next;
        }
        Stack<ListNode> stackB = new Stack<>();
        while (headB != null){
            stackB.push(headB);
            headB = headB.next;
        }
        while (!stackA.empty() && !stackB.empty()){
            ListNode node = stackA.pop();
            if (node != stackB.pop()){
                break;
            }
            ret = node;
        }
        return ret;
    }


    // 538. 把二叉搜索树转换为累加树 todo 还不会
    public TreeNode convertBST(TreeNode root) {
        sumNode2(root);
        return root;
    }

    private void sumNode2(TreeNode node){
        if (null == node){
            return;
        }
        sumNode2(node.right);
        sumNode2(node.left);

    }
}
