package tree;

import java.util.*;

public class ListNodeDemo {

    public static void main(String[] args) {

        // int n1 = 3999999999;
        int n2 = 7;

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(2);
        root.next.next.next.next.next = new ListNode(1);
        // root.next.next.next.next.next.next = new ListNode(6);
        removeDuplicateNodes(root);
    }

    // 剑指 Offer 22. 链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = slow;
        while (k > 0){
            if (null == fast.next){
                return null;
            }
            fast = fast.next;
            k--;
        }
        while (null != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 440. 字典序的第K小数字
    public int findKthNumber(int n, int k) {
        return 0;
    }

    /*
    * 给你两个 非空 的链表，表示两个非负的整数。
    * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    * 请你将两个数相加，并以相同形式返回一个表示和的链表。
    * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int n) {
        ListNode ret = null;
        int val = 0;
        if (null != l1 && null != l2){
            val = l1.val + l2.val + n;
            ret = new ListNode(val % 10);
            ret.next = addTwoNumbers(l1.next, l2.next, val / 10);
        } else if (null != l1){
            val = l1.val + n;
            ret = new ListNode(val % 10);
            ret.next = addTwoNumbers(l1.next, null, val / 10);
        } else if (null != l2){
            val = l2.val + n;
            ret = new ListNode(val % 10);
            ret.next = addTwoNumbers(null, l2.next, val / 10);
        } else if (n > 0){
            return new ListNode(n);
        }
        return ret;
    }
    // 82. 删除排序链表中的重复元素 II 
    // TODO: 2021/2/18 想不到解法 
    // 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字
    public ListNode deleteDuplicates82(ListNode head) {
        if (null == head){
            return null;
        }
        Map<Integer, Integer> count = new HashMap<>();
        ListNode prev = head;
        ListNode cur = prev.next;

        while (cur != null){
            if (count.get(cur.val) == null){
                count.put(cur.val, 0);
                prev = cur;
                cur = prev.next;
            } else {
                count.put(cur.val, count.get(cur.val) + 1);
                cur = cur.next;
            }
        }
        while (count.get(head.val) == 0){
            head = head.next;
        }

        return head;
    }

    // 83. 删除排序链表中的重复元素
    public ListNode deleteDuplicates83(ListNode head) {
        if (null == head){
            return null;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null){
            if (cur.val != pre.val){
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }

    // 面试题 02.01. 移除重复节点
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> occurred = new HashSet<>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack_1 = new Stack<>();
        while (l1 != null){
            stack_1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack_2 = new Stack<>();
        while (l2 != null){
            stack_2.push(l2.val);
            l2 = l2.next;
        }
        ListNode cur = null;

        int l = 0;
        while (!stack_1.empty() || !stack_2.empty()){
            int n;
            if (stack_1.empty()){
                n = stack_2.pop() + l;
            } else if (stack_2.empty()){
                n = stack_1.pop() + l;
            } else {
                n = stack_1.pop() + stack_2.pop() + l;
            }
            l = n / 10;
            ListNode tmp = new ListNode(n % 10);
            tmp.next = cur;
            cur = tmp;
        }
        if (l > 0){
            ListNode ret = new ListNode(l);
            ret.next = cur;
            return ret;
        }
        return cur;
    }


}
