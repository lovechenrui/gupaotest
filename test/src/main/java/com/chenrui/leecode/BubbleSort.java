package com.chenrui.leecode;

public class BubbleSort {
    public static void main(String[] args) {
        int [] array ={1,7,5,9,3,2};
        sort(array);
        for(int i:array){
            System.out.println(i);
        }
    }
    static void sort(int [] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]<array[j+1]){
                    int temp = array[j];
                    array[j]= array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
}
