// 213. 打家劫舍 II
public class Problem213 {
    public int solutionNum = 1;


    public int[] nums = {2,3,2};

    public int solution1(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(dp(nums,0,nums.length-2),dp(nums,1,nums.length-1));
    }

    public int dp(int[] nums, int start, int end) {
        int p = 0;
        int q = nums[start];
        int r = Math.max(nums[start], nums[start+1]);
        for (int i = start + 2; i <= end; i++) {
            p = q;
            q = r;
            r = Math.max(p+nums[i], q);
        }
        return r;
    }

    public static void main(String[] args) {
        Problem213 problem213 = new Problem213();
        System.out.println(problem213.solution1(problem213.nums));
    }
}
