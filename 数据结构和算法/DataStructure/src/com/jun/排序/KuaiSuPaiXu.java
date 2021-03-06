package com.jun.排序;

import java.util.Arrays;

//参考：http://www.cnblogs.com/en-heng/p/6336625.html
public class KuaiSuPaiXu {

	public static void main(String[] args) {
		int[] list = { 4, 1, 2, 5, 6,7,3 };
		//排序之前
		System.out.println(Arrays.toString(list));
		quickSort(list, 0, list.length - 1);
		//排序之后
		System.out.println(Arrays.toString(list));
	}

	// 快速排序(快排)
	public static void quickSort(int arr[], int left, int right) {
		if (left >= right)
			return;
		int index = partition(arr, left, right);
		quickSort(arr, left, index - 1);
		quickSort(arr, index + 1, right);
	}

	// partition subarray a[left..right] so that a[left..j-1] >= a[j] >=
	// a[j+1..right]
	// and return index j
	private static int partition(int arr[], int left, int right) {
		int i = left, j = right + 1, pivot = arr[left];
		while (true) {
			while (i < right && arr[++i] > pivot)
				if (i == right)
					break;
			while (j > left && arr[--j] < pivot)
				if (j == left)
					break;
			if (i >= j)
				break;
			swap(arr, i, j);
			System.out.println(Arrays.toString(arr));
		}
		swap(arr, left, j); // swap pivot and a[j]
		System.out.println(Arrays.toString(arr));
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
