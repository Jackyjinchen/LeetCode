// 42. 接雨水
public class Problem42 {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }


    public static int trap(int[] height) {
        if (height.length < 2) return 0;
        int ans = 0;
        int size = height.length;

        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = height[0];
        for (int i = 1; i < size; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        right[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        for (int i = 0; i < size; i++) {
            ans = ans + Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }
}
