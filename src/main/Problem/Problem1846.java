import java.util.Arrays;

class Problem1846 {

    public int solutionNum = 2;

    int[] arr = {1,2,3,5,12,23,6};

    public void solution1() {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] + 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        System.out.println(arr[arr.length - 1]);
    }

    public void solution2() {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int v : arr) {
            cnt[Math.min(v, n)]++;
        }
        int miss = 0;
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] == 0) {
                ++miss;
            } else {
                miss -= Math.min(cnt[i] - 1, miss);
            }
        }
        System.out.println(n - miss);
    }

    public void solution3() {

    }


}