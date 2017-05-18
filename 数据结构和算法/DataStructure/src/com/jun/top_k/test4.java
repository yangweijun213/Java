package com.jun.top_k;

import java.util.Arrays;

public class test4 {
	public static void main(String[] args) {
		int[] list = { 4, 1, 2, 5, 6, 7 };
		int k = 3;

		// Top K-largest - 方法1.快排,最大的3个
		int[] arr = findKLargest(list, k);
		System.out.println("Top K-largest - 方法1.快排,最大的3个: " + Arrays.toString(arr));
	}

	// Top K-Largest - 方法1.快排,最大的3个
	public static int[] findKLargest(int[] array, int k) {
		int left = 0;
		int right = array.length - 1;
		int[] list = new int[3];
		quickSort(array, left, right);
		System.out.println("快排之后: " + Arrays.toString(array));
		for (int i = 0; i < k; i++) {
			list[i] = array[i];
		}
		return list;
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
	// 从大到小
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
		}
		swap(arr, left, j); // swap pivot and a[j]
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
