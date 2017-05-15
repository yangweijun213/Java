package com.jun.排序;

public class ZhiJieChaRu2 {

	public static void main(String[] args) {

		int[] list = { 1, 2, 3, 4, 5, 6, 7 };
		funDInsertSort(list);
	}

	// 直接插入排序 - 从大到小
	static void funDInsertSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			// 后者元素
			int temp = array[i];
			// 前者元素
			int j = i - 1;

			while (j > -1 && temp > array[j]) {
				// 前面的元素复制到后者
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}

	}
}
