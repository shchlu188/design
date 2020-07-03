package com.scl.data.sort;

/**
 * 冒泡排序
 */
class BubbleSort implements Sort{

    @Override
    public void sort(int[] arr) {
        Sort.checkArray(arr);
        boolean flag ;
        for (int i = 0; i < arr.length; i++) {
            flag=true;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j+1]<arr[j]){
                    flag=false;
                    Sort.swap(arr,j,j+1);
                }
            }
            if (flag){
                break;
            }
        }
    }
  /*  @Override
    public void sort(int[] arr) {
        Sort.checkArray(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j+1]<arr[j]){
                    Sort.swap(arr,j,j+1);
                }
            }
        }
    }*/
}
