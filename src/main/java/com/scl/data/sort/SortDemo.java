package com.scl.data.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description 排序
 */

public class SortDemo {
    public static void main(String[] args) {
        Sort sort = new ShellSort(); // 16600
        test(sort);
    }

    /**
     * 排序测试
     * @param sort
     */
    private static void test(Sort sort) {
        int[] target=getRandomArray(10000,100000);
        printArr(target);
        long startTime = System.nanoTime();
        sort.sort(target);
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
        printArr(target);
    }

    private static boolean check(int[] target,Sort sort){
        int[] tmp = new int[target.length];
        System.arraycopy(target,0,tmp,0,target.length);
        sort.sort(target);
        Arrays.sort(tmp);
        return Arrays.equals(tmp,target);

    }
    /**
     * 获取随机数组
     *
     * @param len   长度
     * @param round 范围
     * @return
     */
    public static int[] getRandomArray(int len, int round) {
        Random random = new Random();
        int tmp = 0;
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            tmp = random.nextInt(round);
            arr[i] = tmp;
        }
        return arr;
    }


    private static void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }



}


