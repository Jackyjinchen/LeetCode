// 746. 使用最小花费爬楼梯
public class Problem746 {
    public int solutionNum = 1;

    int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

    public int solution1(int[] cost) {
        int p = 0, q = 0, r = 0;
        for (int i = 2; i <= cost.length; i++) {
            r = Math.min(p + cost[i - 2], q + cost[i - 1]);
            p = q;
            q = r;
        }
        return r;
    }

    public static void main(String[] args) {
        Problem746 pro = new Problem746();
        System.out.println(pro.solution1(pro.cost));
    }

}
