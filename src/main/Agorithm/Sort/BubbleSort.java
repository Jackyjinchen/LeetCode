package Sort;

public class BubbleSort {
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // swap的几种方法：
    // 临时变量法
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 算术法
    private void swap1(int[] array, int i, int j) {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }

    // 位运算法
    private void swap2(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j]; //array[i]^array[j]^array[j]=array[i]
        array[i] = array[i] ^ array[j]; //array[i]^array[j]^array[i]=array[j]
    }
}
