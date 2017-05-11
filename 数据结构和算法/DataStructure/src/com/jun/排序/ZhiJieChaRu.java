package com.jun.排序;

public class ZhiJieChaRu {

	public static void main(String[] args) {
		
		int[] list = {7,6,5,4,3,2,1};
		funDInsertSort (list);
	}
	
	// 直接插入排序 - 从小到大
	static void funDInsertSort (int[] array){
		
		for (int i=0; i<array.length;i++){
			//i是后者元素
			int temp = array[i];
			//j是前者元素
			int j= i-1;
			
			while (j>-1 && temp<array[j]){
				array[j+1]=array[j];
				j--;
			}
			//这个时候的J的位置是,插入前的位置
			array[j+1]=temp;
		}
		
		for (int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}
