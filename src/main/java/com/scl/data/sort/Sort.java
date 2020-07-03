package com.scl.data.sort;

interface Sort{
    void sort(int[] arr);
    /**
     * 数组元素交换
     * @param arr
     * @param index
     * @param minPos
     */
    static void swap(int[] arr, int index, int minPos) {
        int tmp = arr[index];
        arr[index] = arr[minPos];
        arr[minPos]=tmp;
    }
    static void checkArray(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("arr is null");
        }
    }
}