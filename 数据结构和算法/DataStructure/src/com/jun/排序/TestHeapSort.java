package com.jun.排序;

import java.util.Arrays;

// 堆排序
public class TestHeapSort {

	public static void main(String[] args) {
		int arr[] = { 5, 6, 1, 0, 29, 12, 16, 15 };
		heapsort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	static void heapsort(int arr[], int n) {
		System.out.println("开始排序");
		System.out.println(Arrays.toString(arr));
		
		// 先建大顶堆
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapAdjust(arr, i, n);
		}
		System.out.println(Arrays.toString(arr));
		
		for (int i = 0; i < n - 1; i++) {
			swap(arr, 0, n - i - 1);
			heapAdjust(arr, 0, n - i - 1);
			System.out.println(Arrays.toString(arr));
		}
	}

	// 交换两个数
	static void swap(int arr[], int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

	// 调整堆
	static void heapAdjust(int arr[], int index, int n) {
		
		//开始:父节点n/2-1
		int temp = arr[index];
		int child = 0;
		// 儿子节点：n*2+1
		while (index * 2 + 1 < n) {
			child = index * 2 + 1;
			// child为左右孩子中较大的那个.儿子不是最后一个元素
			if (child != n - 1 && arr[child] < arr[child + 1]) {
				child++;
			}
			// 如果指定节点大于较大的孩子 不需要调整
			if (temp > arr[child]) {
				break;
			} else {
				// 否则继续往下判断孩子的孩子 直到找到合适的位置. arr[index]是父亲，arr[child]是大儿子
				arr[index] = arr[child];
				index = child; // 原先父亲的位置被移到大儿子的位置。
			}
		}
		//继续判断，当大儿子作为父亲时候，它和儿子之间的比较。arr[index]是大儿子的儿子，将祖父的值付给了大儿子的儿子。
		arr[index] = temp;
	}
}
