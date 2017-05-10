package com.jun.查找;

public class ErfenChaoZhao1 {

	public static void main(String[] args) {
		// 6个元素
		// int[] list = { 6, 5, 4, 3, 2, 1 };
		// 7个元素
		int[] list2 = { 7,6, 5, 4, 3, 2, 1 };
		// 8个元素
		// int[] list3 = { 8, 6, 5, 4, 3, 2, 1 };
		// 时间复杂度：最坏
		int bad = 1;
		// 时间复杂度：最好
		// int good = 1;

		String result = funBinSearch(list2, bad);
		System.out.println(result);
	}

	// 使用二分查找 - 1个while循环, 先排序->折半->左比或右比
	// 最快是O(1), 最慢是(log2^n)
	static String funBinSearch(int[] list, int data) {

		int low = 0;
		int high = list.length - 1;
		int iteration = 0;

		while (low <= high) {

			// 当值位置
			int med = (low + high) / 2;

//			iteration = iteration + 1;
//			System.out.println("循环次数:" + iteration);
//			System.out.println("low: " + low);
//			System.out.println("med: " + med);
//			System.out.println("high: " + high);

			// 如果找到就返回数字,没有的话就继续判断是左半部分还是右半部分,直到找到数字
			if (data == list[med]) {
				return "找到" + data;
			} else if (data <= list[med]) {
				high = med - 1;
			} else {
				low = med + 1;
			}

		}
		return "没有这个数字";
	}
}
