// 918. 环形子数组的最大和
public class Problem918 {
    public int solutionNum = 1;

    public int solution1(int[] nums) {
        int N = nums.length;

        int ans = nums[0], cur = nums[0];
        for (int i = 1; i < N; ++i) {
            cur = nums[i] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }

        // ans is the answer for 1-interval subarrays.
        // Now, let's consider all 2-interval subarrays.
        // For each i, we want to know
        // the maximum of sum(A[j:]) with j >= i+2

        // rightsums[i] = A[i] + A[i+1] + ... + A[N-1]
        int[] rightsums = new int[N];
        rightsums[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; --i)
            rightsums[i] = rightsums[i + 1] + nums[i];

        // maxright[i] = max_{j >= i} rightsums[j]
        int[] maxright = new int[N];
        maxright[N - 1] = nums[N - 1];
        for (int i = N - 2; i >= 0; --i)
            maxright[i] = Math.max(maxright[i + 1], rightsums[i]);

        int leftsum = 0;
        for (int i = 0; i < N - 2; ++i) {
            leftsum += nums[i];
            ans = Math.max(ans, leftsum + maxright[i + 2]);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        Problem918 problem918 = new Problem918();
        System.out.println(problem918.solution1(nums));
    }
}
