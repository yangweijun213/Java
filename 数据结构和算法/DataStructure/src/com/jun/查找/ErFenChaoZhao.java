package com.jun.查找;

public class ErFenChaoZhao {

	public static void main(String[] args) {
		//二分查找使用之前:数列必须是一个有序的
		int[] list = { 1, 2, 3, 4, 5, 6 };
		//数字5的index
		int searchKey = 5;
		System.out.println("数字5的index: "+funBinSearch(list, searchKey));
	}

	// 二分查找
	// 最好O(1), 最坏(log2^n)
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
