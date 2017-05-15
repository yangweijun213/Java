package com.jun.排序;

public class MaoPao2 {

	public static void main(String[] args) {
		int[] list2 = { 1,2,3,4,5,6 };
		funBubbleSort(list2);
	}

	// 冒泡排序 - 从大到小排序
	static void funBubbleSort(int[] array){
		boolean flag = true;
		for (int i=0;i<array.length-1&&flag;i++){
			flag = false;
			for (int j=0;j<array.length-1-i;j++){
				if (array[j]<array[j+1]){
					int temp = array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
					flag=true;
				}
			}
		}
		
		for (int i=0; i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
