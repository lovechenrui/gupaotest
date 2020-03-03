package com.chenrui.leecode;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = new int[]{2, 7, 11, 15};
        int L =0;
        int R = a.length-1;
        sort(a,L,R);
        pringList(a);
    }
    public static void pringList(int[] list){
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+"\t");
        }
    }
    private static void sort(int[] a, int l, int r) {
        if( l == r ){
            return;
        }
        int mid = l+((r-l)>>1);
        System.out.println(mid);
        sort(a,l,mid);
        sort(a,mid+1,r);
        merge(a,l,mid,r);
    }

    private static void merge(int[] a, int l, int mid,int r) {
        int i=0;
        int [] temp = new int[r-l+1];
        int leftIndex=l;
        int rightIndex =mid+1;
        //左右两边第一个数开始比较，小的放入新数组，只到左边或者右边完全放入新数组
        while(leftIndex <=mid && rightIndex<=r){
            temp[i++] = a[leftIndex] < a[rightIndex]?a[leftIndex++] : a[rightIndex++];
        }
       // 把剩余的有序数添追加到新数组中,
        while (leftIndex<=mid){
            temp[i++] = a[leftIndex++];
        }
        while (rightIndex<=r){
            temp[i++] = a[rightIndex++];
        }
        for (i=0;i<temp.length;i++){
            a[l+i]=temp[i];
        }
    }
}
