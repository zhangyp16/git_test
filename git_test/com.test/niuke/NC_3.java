package niuke;

import java.util.*;

public class NC_3 {

    public static void main(String[] args) {
        // head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);

        ListNode next = new ListNode(2);
        next.next = new ListNode(0);
        next.next.next = new ListNode(-4);

        next.next.next.next = next;
        head.next = next;

        // System.out.println(detectCycle2(head));

        System.out.println(solve("syewwtsgprrkebafptmvicizqrsszltspftnbtkeairfpuumqzruiacrjvvvppcffjktpuctaifytzcityczvuhnekfuxfhxflldchzgzaneldaehovlwftesmthzdbsdzopkexmmfidcckjfpvuaagpeeyoeqwdzzomfumnfzmebooaaofhwvnmzikmrnhvvcoxukfdmbntszwvevzntzhmvntcrnsublqfrueygjzdeytkftppibxyhbqgwmlcpvqrm"));
    }

    // 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
    public static ListNode detectCycle(ListNode head) {
        if (null == head){
            return null;
        }
        ListNode slow = head, fast = slow.next;
        while (null != fast && null != fast.next){
            if (slow.next.val == fast.next.val){
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        if (null == head){
            return null;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null){
            if (null != map.get(cur.val)){
                return cur;
            }
            map.put(cur.val, cur);
            cur = cur.next;
        }
        return null;
    }

    public static ListNode detectCycle3(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    // 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
    public boolean hasCycle(ListNode head) {
        if (null == head){
            return false;
        }
        ListNode slow = head, fast = slow.next;
        while (null != fast && null != fast.next){
            if (slow.val == fast.val){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    // NC 103 反转字符串
    public static String solve (String str) {
        // write code here
        char[] strArr = str.toCharArray();
        int start = 0, end = str.length() - 1;
        while (start < end){
            char tmp = strArr[start];
            strArr[start] = strArr[end];
            strArr[end] = tmp;
            start++;
            end--;
        }
        return String.valueOf(strArr);
        /*StringBuilder sb = new StringBuilder();
        for (char s : strArr){
            sb.append(s);
        }
        return sb.toString();*/
    }
}
