public class Problem1137 {
    public int solutionNum = 1;

    public int n = 25;

    public int solution1(int n) {
        if(n<2) return n;
        if(n==2) return 1;
        int l = 0, m = 0, r = 1, ans = 1;
        for (int i = 3; i <= n; i++) {
            l = m;
            m = r;
            r = ans;
            ans = l + m + r;
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem1137 pro = new Problem1137();
        System.out.println(pro.solution1(pro.n));
    }
}
