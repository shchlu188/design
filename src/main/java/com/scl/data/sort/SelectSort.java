package com.scl.data.sort;

/**
 * 选择排序
 */
class SelectSort implements Sort{

    @Override
    public void sort(int[] arr) {
        Sort.checkArray(arr);
        int len = arr.length;
        assert len > 1;
        for (int i = 0; i < len; i++) {
            int minPos = i;
            for (int j = i + 1; j < len; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            if (minPos!=i){
                Sort.swap(arr, i, minPos);
            }
        }
    }
}