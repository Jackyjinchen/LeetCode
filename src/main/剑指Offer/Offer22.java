package main.剑指Offer;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/2
 * @Content: 剑指 Offer 22. 链表中倒数第k个节点
 * 最简单方式是计算总数量，再遍历一次。
 * 双指针同步走，一次遍历。
 */
public class Offer22 {

    public static void main(String[] args) {
//        1->2->3->4->5
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        int k = 2;
        System.out.println(getKthFromEnd(l1, k).val);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head, pos = head;
        while (k > 1 && pos.next !=null) {
            pos = pos.next;
            k--;
        }
        while (pos.next!=null) {
            pre = pre.next;
            pos = pos.next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
