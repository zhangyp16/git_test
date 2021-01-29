package tree;

public class ListNodeDemo {

    public static void main(String[] args) {

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
}
