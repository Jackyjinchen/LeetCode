import javax.management.Query;
import java.util.*;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/7
 * @Content: 457. 环形数组是否存在循环
 */
public class Problem457 {

    public static void main(String[] args) {
        int[] nums = {2,-1,1,2,2};
        System.out.println(circularArrayLoop(nums));
    }

    public static boolean circularArrayLoop(int[] nums) {
        if (nums == null) return false;
        int n = nums.length;
        boolean res = false;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int sign = nums[pos] > 0 ? 1 : -1;
            set.add(pos);
            System.out.println("开始" + pos);
            while (!set.isEmpty()) {
                int newPos = (pos + nums[pos]) % n;
                if (newPos < 0) newPos = n + newPos;
                if (pos == newPos) {
                    set.clear();
                    break;
                } else if (set.contains(newPos)) {
                    return true;
                } else {
                    pos = newPos;
                    if (nums[pos] / sign > 0) {
                        set.add(pos);
                        queue.remove(pos);
                    } else {
                        set.clear();
                    }
                }
            }
        }

        return false;
    }
}
