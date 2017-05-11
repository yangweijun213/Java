package com.jun.排序;

public class HeBinPaiXu {

	public static void main(String[] args) {
		int[] list = { 5, 6, 7, 4, 3, 2, 1 };
		funMergeSort(list);

		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}

	// 从小到大
	// 归并排序
	static void funMergeSort(int[] array) {

		if (array.length > 1) {

			int length1 = array.length / 2;
			int[] array1 = new int[length1];
			System.arraycopy(array, 0, array1, 0, length1);
			//不断的拆分，直到拆到一个为止s
			funMergeSort(array1);

			int length2 = array.length - length1;
			int[] array2 = new int[length2];
			System.arraycopy(array, length1, array2, 0, length2);
			//不断的拆分，直到拆到一个为止
			funMergeSort(array2);

			int[] datas = merge(array1, array2);
			System.arraycopy(datas, 0, array, 0, array.length);
		}

	}

	// 合并两个数组
	static int[] merge(int[] list1, int[] list2) {

		int[] list3 = new int[list1.length + list2.length];

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
		//先进行两个数组的比较，将小的那组元素，全部移植到list3数组
		while (count1 < list1.length && count2 < list2.length) {

			if (list1[count1] < list2[count2]) {
				list3[count3++] = list1[count1++];
			} else {
				list3[count3++] = list2[count2++];
			}
		}
		
		//如果一方数组被移植后，另一方继续被全部移过去。
		while (count1 < list1.length) {
			list3[count3++] = list1[count1++];
		}

		while (count2 < list2.length) {
			list3[count3++] = list2[count2++];
		}

		return list3;
	}

}
