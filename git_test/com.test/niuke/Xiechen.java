package niuke;

public class Xiechen {

    public static void main(String[] args) {
        // System.out.println(sqrt4(1518991037));
        // System.out.println(Math.sqrt(1518991037));
        // System.out.println(sqrt2(6));

        // System.out.println(sqrt3(1518991037));

        // System.out.println(upper_bound_(5, 4, new int[]{1,2,4,4,5}));

        System.out.println(removeNthFromEnd(new ListNode(1), 1));
    }

    public static int sqrt2 (int x) {
        // write code here
        for (int i = (x % 2 == 0 ? x / 2 : (x / 2) + 1); i >= 1; i--){
            if (i <= (x / i)){
                return i;
            }
        }
        return 0;
    }

    public static int sqrt3 (int x) {
        // write code here
        int start = 1, end = x;
        int mid = start + (end - start) / 2;
        while (start < end){
            if (mid == (x / mid)){
                return mid;
            } else if (mid > (x / mid)){
                end = mid;
            } else {
                start = mid;
            }
            mid = start + (end - start) / 2;
        }
        return start;
    }

    // //牛顿法思路
    public static int sqrt4 (int x) {
        // write code here
        if (x == 0 || x == 1){
            return x;
        }
        int r = x;
        while (x / r < r){
            r = (r + x / r) / 2;
        }
        return r;
    }



    /**
     * 二分查找   输出在数组中第一个大于等于查找值的位置
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_ (int n, int v, int[] a) {
        // write code here
        if (a[n - 1] < v){
            return n + 1;
        }
        int start = 0, end = n - 1;
        int mid = start + (end - start) / 2;
        while (start < end){
            if (a[mid] >= v){
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return mid + 1;
    }


    /**
     * NC 53 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode first = new ListNode(0);
        first.next = head;

        ListNode slow = first, fast = slow.next;
        while (n > 1){
            fast = fast.next;
            n--;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return first.next;
    }
}
