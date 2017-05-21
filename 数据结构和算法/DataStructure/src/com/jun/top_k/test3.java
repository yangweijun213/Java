package com.jun.top_k;

import java.util.Arrays;

public class test3 {
	public static void main(String[] args) {
		int[] list = { 4, 1, 2, 5, 6, 7 };

		// 找出Top Kth
		int k = 3;
		int kthElement = findKthLargest(list, k);
		System.out.println("找出Top Kth: "+kthElement);
	}

	
	// 解决TOP K -快速选择 - 找出Kth
	// 参考: http://www.cnblogs.com/en-heng/p/6336625.html
	// 平均：O(nlog2^n) 最好：O(nlog2^n) 最坏：O(n^2) http://www.jianshu.com/p/42f81846c0fb
	public static int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, k, 0, nums.length - 1);
	}

	// quick select to find the kth-largest element
	public static int quickSelect(int[] arr, int k, int left, int right) {
		if (left == right)
			return arr[right]; // 如果只有1个,直接返回这个数
		int index = partition(arr, left, right); // 快选,返回主元素
		if (index - left + 1 > k) // 从主元素和第一个元素之间的元素差数 大于K, 然后在主元素的左边寻找。
			return quickSelect(arr, k, left, index - 1);
		else if (index - left + 1 == k)// 主元素的位置和K元素的位置相同。
			return arr[index];
		else
			return quickSelect(arr, k - index + left - 1, index + 1, right);
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
