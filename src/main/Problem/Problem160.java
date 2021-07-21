import java.util.HashSet;

public class Problem160 {

    public int solutionNum = 3;


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 先获取两个串的长度，然后较长的链表跳过两者长度差后，同步找相同的节点。
    public ListNode solution1(ListNode headA, ListNode headB) {
        ListNode tempNodeA = headA;
        ListNode tempNodeB = headB;
        int lenA = 0, lenB = 0;
        while (tempNodeA != null) {
            tempNodeA = tempNodeA.next;
            lenA++;
        }
        while (tempNodeB != null) {
            tempNodeB = tempNodeB.next;
            lenB++;
        }
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    // 通过Set来存储节点
    public ListNode solution2(ListNode headA, ListNode headB) {
        ListNode tempNode = headA;
        HashSet<ListNode> listNodes = new HashSet<>();
        while (tempNode != null) {
            listNodes.add(tempNode);
            tempNode = tempNode.next;
        }
        tempNode = headB;
        while (tempNode != null) {
            if (listNodes.contains(tempNode)) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        return null;

    }

    public ListNode solution3(ListNode headA, ListNode headB){
        if(headA==null||headB==null) return null;
        ListNode pA=headA;
        ListNode pB=headB;

        while(pA!=pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        Problem160 pro = new Problem160();

        ListNode LA1 = new ListNode(4);
        ListNode LA2 = new ListNode(1);
        ListNode LC1 = new ListNode(8);
        ListNode LC2 = new ListNode(4);
        ListNode LC3 = new ListNode(5);
        ListNode LB1 = new ListNode(5);
        ListNode LB2 = new ListNode(0);
        ListNode LB3 = new ListNode(1);

        LA1.next = LA2;
        LA2.next = LC1;
        LB1.next = LB2;
        LB2.next = LB3;
        LB3.next = LC1;
        LC1.next = LC2;
        LC2.next = LC3;

        System.out.println(pro.solution3(LA1, LB1).val);
    }

}
