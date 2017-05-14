package com.jun.查找;

public class ErFenChaoZhao {

	public static void main(String[] args) {

		int[] list = { 1, 2, 3, 4, 5, 6 };
		System.out.println(funBinSearch(list, 5));
	}

	// 使用二分查找 - 提前是一个升序的线性表->折半->左比或右比
	// 最快是O(1), 最慢是(log2^n)
	static int funBinSearch(int[] list, int data) {

		int low = 0;
		int high = list.length - 1;

		while (low <= high) {

			// 当值位置
			int med = (low + high) / 2;
			// 如果找到就返回数字,没有的话就继续判断是左半部分还是右半部分,直到找到数字
			if (data == list[med]) {
				return med;
			} else if (data <= list[med]) {
				high = med - 1;
			} else {
				low = med + 1;
			}

		}
		return -1;
	}
}
