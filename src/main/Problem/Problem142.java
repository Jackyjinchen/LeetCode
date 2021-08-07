import java.util.List;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/7
 * @Content: 142. 环形链表 II
 */
public class Problem142 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(3);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(-4);
        l0.next=l1;l1.next=l2;l2.next=l3;l3.next=l1;
        System.out.println(detectCycle(l0).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow = head, fast = head;
        while (fast!=null) {
            if(fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }
}
