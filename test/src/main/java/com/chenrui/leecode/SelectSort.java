package com.chenrui.leecode;

import java.util.Arrays;

/**
 * 选择排序:找到最小数字的下标，
 * 时间复杂度：N（(n-1)(N-1+1)/2）
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] array ={49,38,65,97,76,13,27,49};
        sort(array);
        for(int i:array){
            System.out.println(i);
        }
    }
    static void sort(int [] array){
        for(int i=0;i<array.length;i++){//循环n
            int minPos = i;
            for(int j=i;j<array.length;j++){//循环n(n+1)/2
                if(array[j]<array[minPos]){
                    minPos=j;
                }
            }
            swap(i,minPos,array);
            System.out.println(Arrays.toString(array) );
        }
    }
    static void swap(int i,int minPos,int [] array){
        int temp = array[minPos];
        array[minPos] = array[i];
        array[i] = temp;
    }
}
