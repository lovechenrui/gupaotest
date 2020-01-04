package com.chenrui.leecode;

/**
 * 选择排序
 * 时间复杂度：N（(n-1)(N-1+1)/2）
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] array ={1,7,5,9,3,2};
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
        }
    }
    static void swap(int i,int minPos,int [] array){
        int temp = array[minPos];
        array[minPos] = array[i];
        array[i] = temp;
    }
}
