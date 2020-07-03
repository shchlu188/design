package com.scl.data.sort;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description 插入排序
 */
public class InsertSort implements Sort {
    @Override
    public void sort(int[] arr) {
        sort02(arr);
    }

    private void sort01(int[] arr){
        Sort.checkArray(arr);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                Sort.swap(arr,j,j-1);
            }
        }
    }
    private void sort02(int[] arr){
        Sort.checkArray(arr);
        for (int i = 1; i < arr.length; i++) {
            int tmp =arr[i];
            int insertIndex = i;
            for (int j = i; j > 0 && tmp< arr[j - 1]; j--) {
                arr[j]=arr[j-1];
                insertIndex--;
            }
            arr[insertIndex]=tmp;

        }
    }
}
