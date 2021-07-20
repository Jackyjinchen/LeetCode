public class Problem509 {
    public int solutionNum = 1;

    public int n = 4;

    // 递归
    public int solution1(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return solution1(n - 1) + solution1(n - 2);
        }
    }

    // 动态规划
    public int solution2(int n) {
        if (n < 2) return n;
        int l = 0, m = 1, r = 2;
        for (int i = 2; i <= n; i++) {
            r = l + m;
            l = m;
            m = r;
        }
        return r;
    }


    public static void main(String[] args) {
        Problem509 pro = new Problem509();
        System.out.println(pro.solution2(pro.n));
    }

}

