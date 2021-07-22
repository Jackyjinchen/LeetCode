package Sort;

// 这里只给出所有数据均为正整数的一种计算方式。
public class RadixSort {
    public void sort(int[] arr) {
        int max = findMax(arr);

        for (int i = 1; max / i > 0; i *= 10) {
            int[][] buckets = new int[arr.length][10];
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] / i) % 10;
                buckets[j][num] = arr[j];
            }
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < arr.length; l++) {
                    if (buckets[l][j] != 0) {
                        arr[k++] = buckets[l][j];
                    }
                }
            }
        }


    }

    private int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
