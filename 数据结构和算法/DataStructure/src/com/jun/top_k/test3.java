package com.jun.top_k;

public class test3 {

	public static void main(String[] args) {
		int[] list = { 0, 9, 8, 7, 1, 2, 3, 4, 5, 6 };

		// 快速选择 - 找出从10个元素中，找出前3个最大的
		for (int k=3; k>0;k--){
			System.out.println(findKthLargest(list, k));
		}
	}
	
	// 解决TOP K -快速选择排序 
	public static int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, k, 0, nums.length - 1);
	}

	// quick select to find the kth-largest element
	public static int quickSelect(int[] arr, int k, int left, int right) {
		if (left == right)
			return arr[right];
		int index = partition(arr, left, right);
		if (index - left + 1 > k)
			return quickSelect(arr, k, left, index - 1);
		else if (index - left + 1 == k)
			return arr[index];
		else
			return quickSelect(arr, k - index + left - 1, index + 1, right);
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
