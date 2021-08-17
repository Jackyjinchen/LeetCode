import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/17
 * @Content:
 */
public class Problem526 {

    public static void main(String[] args) {
        int n =  5;
        System.out.println(countArrangement(n));
    }

    static List<Integer>[] match;
    static boolean[] vis;
    static int num;

    public static int countArrangement(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return num;
    }

    public static void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }
        for (int x : match[index]) {
            if (!vis[x]) {
                vis[x] = true;
                backtrack(index + 1, n);
                vis[x] = false;
            }
        }
    }
}
