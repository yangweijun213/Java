package com.jun.排序;

import java.util.Arrays;

public class ZhiJieXuanZe {

	public static void main(String[] args) {
		int[] array ={4,3,2,1};
		//稳定性测试
		int[] array2 ={4,4,2,1};
		funSelectionSort (array2);
	}
	
	// 选择排序 - 从小到大
	static void funSelectionSort(int[] array) {
		
		//排序开始
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length - 1; i++) {
			int mink = i;		
			// 每次从未排序数组中找到最小值的坐标
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[mink]) {
					mink = j;
				}
			}

			// 将最小值放在最前面
			if (mink != i) {
				int temp = array[mink];
				array[mink] = array[i];
				array[i] = temp;
				System.out.println(Arrays.toString(array));
			}
		}

	}

}