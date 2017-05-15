package com.jun.排序;

import java.util.Arrays;

public class ZhiJieChaRu {

	public static void main(String[] args) {

		int[] list = { 4, 3, 2, 1 };
		//最好情况
		int[] list2 = { 1,2,3,4};
		// 排序开始
		System.out.println(Arrays.toString(list));
		funDInsertSort(list);
	}

	// 直接插入排序 - 从小到大
	static void funDInsertSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			// i是后者元素
			int temp = array[i];
			// j是前者元素
			int j = i - 1;

			while (j > -1 && temp < array[j]) {
				array[j + 1] = array[j];
				j--;
				System.out.println(Arrays.toString(array));
			}
			// array[j + 1]就是需要插入的位置
			array[j + 1] = temp;
			System.out.println(Arrays.toString(array));
		}

	}
}
