import java.util.*;

public class Problem740 {

    public int solutionNum = 2;

    public int[] nums = {3,1};

    public int soulution1(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] ints = new int[max + 1];
        for (int num : nums) {
            ints[num] += num;
        }

        return rob(ints);
    }

    public int rob(int[] nums) {
        int p = 0, q = nums[0], r = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            p = q;
            q = r;
            r = Math.max(p + nums[i], q);
        }

        return r;
    }

    public int soulution2(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        List<Integer> sum = new ArrayList<>();
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (val == nums[i - 1]) {
                sum.set(size - 1, sum.get(size - 1) + val);
            } else if (val == nums[i - 1] + 1) {
                sum.add(val);
                ++size;
            } else {
                res += robList(sum);
                sum.clear();
                sum.add(val);
                size = 1;
            }
        }
        res += robList(sum);
        return res;
    }

    public int robList(List<Integer> sums) {
        if (sums.size() == 1) {
            return sums.get(0);
        }
        int p = 0, q = sums.get(0), r = Math.max(sums.get(0), sums.get(1));
        for (int i = 2; i < sums.size(); i++) {
            p = q;
            q = r;
            r = Math.max(p + sums.get(i), q);
        }
        return r;
    }

    public static void main(String[] args) {
        Problem740 problem740 = new Problem740();
        System.out.println(problem740.soulution2(problem740.nums));
    }

}
