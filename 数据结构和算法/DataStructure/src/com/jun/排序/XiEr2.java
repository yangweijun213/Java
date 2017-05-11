package com.jun.排序;

public class XiEr2 {

	public static void main(String[] args) {

		int[] list = { 13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 39, 10 };
		shellSort(list);
	}

	// 希尔排序 - 从大到小
	static void shellSort(int[] list) {
		int d = list.length;
		while (true) {
			d = d / 2;
			for (int i = 0; i < d; i++) {
				for (int j = i + d; j < list.length; j=j+d) {
					// 组尾
					int temp = list[j];
					int k;
					for (k = j - d; k >= 0 && list[k]<temp; k = k - d) {
						//  组尾list[k+d], 组头 list[k]
						list[k + d] = list[k];
					}
					// 组头
					list[k + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
		}
		
		for (int i=0;i<list.length;i++){
			System.out.println(list[i]);
		}
	}
}
