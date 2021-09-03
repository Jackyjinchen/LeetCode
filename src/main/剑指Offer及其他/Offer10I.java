// 剑指 Offer 10- I. 斐波那契数列
public class Offer10I {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = (a + b) % (1000000007);
            a = b;
            b = res;
        }
        return res;
    }
}
