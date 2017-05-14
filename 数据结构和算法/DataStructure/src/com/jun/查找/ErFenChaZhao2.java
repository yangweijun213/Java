package com.jun.查找;

public class ErFenChaZhao2 {

	public static void main(String[] args) {

		int[] list = new int[100];
		int value = 1;
		System.out.println("=======数据源======");
		// 在1-100中，寻找4
		for (int i = 0; i < list.length; i++) {
			list[i] = value++;
			System.out.print(list[i] + ",");
		}
		int keyword = 4;
		System.out.print("\r\n搜索:" + keyword + "\r\n");
		System.out.println("=======搜索结果======");
		int intPos = funSearchNum(list, keyword);
		if (intPos != -1) {
			System.out.println("找到的位置：" + intPos);
			System.out.println("找到的数字：" + list[intPos]);
		}

		// 在字符串abcdef,中找到c
		String list2 = "abcdef";
		char charKeyWord = 'c';
		int strPos = funSearchStr(list2, charKeyWord);
		System.out.println("====================");
		System.out.println("字符串是："+list2);
		System.out.println("查找："+charKeyWord);
		if (strPos != -1) {
			System.out.println("找到的位置：" + strPos);
			System.out.println("找到的字符：" + list2.charAt(strPos));
		}
	}

	// 使用二分查找 - 在排序好的数字中，查找关键关键字。
	static int funSearchNum(int[] array, int keyword) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int med = (high + low) / 2;
			if (keyword == array[med]) {
				return med;
			} else if (keyword < array[med]) {
				high = med - 1;
			} else {
				low = med + 1;
			}
		}
		return -1;
	}

	// 使用二分查找 - 在排序好的字符串中，查找关键字
	static int funSearchStr(String str, char charKeyWord) {
		int low = 0;
		int high = str.length() - 1;
		while (low < high) {
			int med = (low + high) / 2;
			if (charKeyWord == str.charAt(med)) {
				return med;
			} else if (charKeyWord < str.charAt(med)) {
				high = med - 1;
			} else {
				low = med + 1;
			}
		}
		return -1;
	}
}
