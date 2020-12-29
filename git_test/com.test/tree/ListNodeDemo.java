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
}
