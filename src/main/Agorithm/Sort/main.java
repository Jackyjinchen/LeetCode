package Sort;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] arr = new int[25];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }


        // 排序前
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        // 冒泡排序
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(arr);


        // 快速排序
//        QuickSort quickSort = new QuickSort();
        // 挖坑法
//        quickSort.sort(arr, 0, arr.length - 1);
        // 指针法
//        quickSort.sort2(arr, 0, arr.length - 1);

        // 直接插入排序
//        InsertionSort insertionSort = new InsertionSort();
        // 移位法
//        insertionSort.sort(arr);
        // 交换法
//        insertionSort.sort2(arr);

        // 希尔排序
//        ShellSort shellSort = new ShellSort();
//        shellSort.sort(arr);

        // 选择排序
//        SelectSort selectSort = new SelectSort();
//        selectSort.sort(arr);

        // 归并排序
//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sort(arr);

        // 基数排序
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);

        // 排序后
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }
}
