package com.jun.排序;

public class XiEr {

	public static void main(String[] args) {
		int[] a = { 9,1,2,5,7,4,8,6,3,5 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// 希尔排序 - 从小到大
		int d = a.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i = i + d) {
					int temp = a[i];
					int j;
					for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
						//a[j]组头,a[j+d]组尾
						a[j + d] = a[j];
						
					}
					//因为这个时候, a[j + d]是组头  (j-d+d); temp是组尾
					a[j + d] = temp;
				}
			}
			if (d == 1) {
				break;
			}
		}
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
