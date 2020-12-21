package niuke;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NiuKeDemo {

    public static void main(String[] args) {
        Xqueue xqueue = new Xqueue();
        xqueue.push(1);
        xqueue.push(2);
        xqueue.push(3);
        System.out.println(xqueue.pop());
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
}
