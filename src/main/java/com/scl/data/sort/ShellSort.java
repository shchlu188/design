package com.scl.data.sort;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] arr) {

//        base01(arr); //867400    733888300
        base02(arr); //615900    370947500
//          base03(arr); //665900  514507700
    }

    private void base01(int[] arr) {

        for (int gap = 4; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        Sort.swap(arr, j, j - gap);
                    }

                }

            }

        }
    }

    private void base02(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        Sort.swap(arr, j, j - gap);
                    }

                }

            }

        }
    }
    private void base03(int[] arr) {
        int h =1;
        while (h<=arr.length/3){
            h = h*3+1;
        }
        for (int gap =h ;gap > 0; gap= (gap>>1)) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        Sort.swap(arr, j, j - gap);
                    }

                }

            }

        }
    }

}
