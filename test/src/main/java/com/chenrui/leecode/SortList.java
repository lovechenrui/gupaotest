package com.chenrui.leecode;

public class SortList {
	public static void main(String[] args) {
		int list[] = new int[]{5,4,21,7,0,9,6};
		int left = 0;
		int right = list.length -1;
		SortList test = new SortList();
		test.quickSort(list,left,right);
		pringList(list);
	}
	public static void pringList(int[] list){
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i]+"\t");
		}
	}
	public int division(int[]list,int left,int right){
		int base = list[left];
		while (left < right && list[right] >= base){
			right --;
		}
		list[left] = list[right];
		while(left < right && list[left] <= base){
			left ++;
		}
		list[right] = list[left];

		list[left] = base;
		return left;
	}

	public void quickSort(int[]list,int left,int right){
		if(left < right){
			int base = division(list, left, right);
			System.out.println("");
			quickSort(list, left, base-1);
			quickSort(list, base+1, right);
		}

	}

}
