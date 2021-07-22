import java.util.HashMap;
import java.util.Map;

public class Problem138 {
    public int solutionNum = 1;


    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node solution1(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<Node, Node>();

        Node tempHead = head;
        Node newHead = new Node(head.val);
        Node tempNewHead = newHead;
        map.put(tempHead,tempNewHead);

        while (tempHead.next!=null) {
            tempNewHead.next = new Node(tempHead.next.val);
            tempHead = tempHead.next;
            tempNewHead = tempNewHead.next;
            map.put(tempHead,tempNewHead);
        }
        tempHead = head;
        tempNewHead = newHead;
        while (tempHead!=null){
            Node randomHead = map.get(tempHead.random);
            if(randomHead!=null) {
                tempNewHead.random = map.get(tempHead.random);
            }

            tempHead = tempHead.next;
            tempNewHead = tempNewHead.next;
        }

        return newHead;
    }


    public static void main(String[] args) {
        Node L0 = new Node(7);
        Node L1 = new Node(13);
        Node L2 = new Node(11);
        Node L3 = new Node(10);
        Node L4 = new Node(1);
        L0.next = L1;
        L1.next = L2;
        L2.next = L3;
        L3.next = L4;
        L1.random = L0;
        L2.random = L4;
        L3.random = L2;
        L4.random = L0;
        Problem138 problem138 = new Problem138();
        problem138.solution1(L0);


    }
}
