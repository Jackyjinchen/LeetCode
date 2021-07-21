// 198. 打家劫舍
public class Problem198 {
    public int solutionNum = 1;


    public int[] nums = {1, 100, 2, 3, 4, 5};

    public int solution1(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int p = 0, q = nums[0], r = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            p = q;
            q = r;
            r = Math.max(p + nums[i], q);
        }

        return r;
    }

    public static void main(String[] args) {
        Problem198 problem198 = new Problem198();
        System.out.println(problem198.solution1(problem198.nums));
    }
}
