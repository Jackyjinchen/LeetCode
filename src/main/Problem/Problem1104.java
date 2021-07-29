import com.sun.jdi.connect.Connector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// 1104. 二叉树寻路
public class Problem1104 {

    public static void main(String[] args) {
        int label = 14;
        System.out.println(pathInZigZagTree(label));
    }

    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        int dept = (int) (Math.log(label) / Math.log(2)) + 1;
        int pos = (int) (Math.pow(2, dept - 1));
        while (dept > 0) {
            list.add(0, label);
            label = label >> 1;
            dept--;
            int posr = pos >> 1;
            label = (pos - 1) - (label - posr);
            pos = posr;
        }
        return list;
    }

    public List<Integer> pathInZigZagTree1(int label) {
        List<Integer> list = new LinkedList<>();
        int dept = (int) (Math.log(label) / Math.log(2)) + 1;
        while (dept > 0) {
            list.add(0, label);
            label /= 2;
            dept--;
            int right = (int) (Math.pow(2, dept) - 1);
            int left = (int) Math.pow(2, dept - 1);
            label = right - (label - left);
        }
        return list;
    }

}
