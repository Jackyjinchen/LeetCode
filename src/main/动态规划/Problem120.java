import java.util.*;
// 120. 三角形最小路径和
public class Problem120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);l3.add(5);l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);l4.add(1);l4.add(8);l4.add(3);
        triangle.add(l1);triangle.add(l2);triangle.add(l3);triangle.add(l4);
        System.out.println(minimumTotal(triangle));

    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 1) return triangle.get(0).get(0);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i+1; j++) {
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

}
