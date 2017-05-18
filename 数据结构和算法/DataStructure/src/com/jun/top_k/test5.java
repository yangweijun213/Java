package com.jun.top_k;

import java.util.Arrays;

public class test5 {
	public static void main(String[] args) {
		int[] list = { 4, 1, 2, 5, 6, 7 };
		int[] list2 = { 4, 1, 2, 5, 6, 7,9,11,13,15,17,22 };
		
		int k = 3;
		// 找出Top K-largest - 方法2. 快选,最大的3个 (这3个没有排序)
		int kth = findKLargest(list2, k);
		System.out.println("k元素: "+kth);
		for (int i = 0; i <= kth; i++) {
			System.out.println("方法2. 快选,最大的3个" + list2[i]);
		}
	}

	// 方法2.快选 - 找出Top K Largest
	public static int findKLargest(int[] array, int k) {
		return quickSelect(array, k, 0, array.length - 1);
	}

	// quick select to find the index of kth-largest
	public static int quickSelect(int[] arr, int k, int left, int right) {
		if (left == right)
			return right; // 如果只有1个,直接返回这个数
		int index = partition(arr, left, right); // 快选,返回主元素
		if (index - left + 1 > k) // 从主元素和第一个元素之间的元素差数 大于K, 然后在主元素的左边寻找。
			return quickSelect(arr, k, left, index - 1);
		else if (index - left + 1 == k)// 主元素的位置和K元素的位置相同。
			return index;
		else
			return quickSelect(arr, k - index + left - 1, index + 1, right); //第k大元素必出现在右子数组中
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
