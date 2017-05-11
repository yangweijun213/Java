package com.jun.排序;

public class XuanZePaiXu2 {
	
	public static void main(String[] args) {
		int[] list = {1,2,3,4,5,6,7};
		SelectionSort(list);
	}
	
	// 选择排序 - 从大到小
	static void SelectionSort(int[] array) {
		
		for (int i=0;i<array.length-1;i++){
			int mlink = i;
			//从后面元素开始
			for (int j=i+1; j<array.length;j++){
				//后面的元素和前一个比较
				if (array[j]>array[mlink]) {
					mlink=j;
				}
			}
			
			if (mlink!=i){
				int temp = array[i];
				array[i] = array[mlink];
				array[mlink] = temp;
			}
		}
		
		for (int i=0; i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
