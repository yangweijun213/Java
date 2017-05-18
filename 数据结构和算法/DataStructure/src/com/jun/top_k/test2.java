package com.jun.top_k;

import java.util.PriorityQueue;

public class test2 {

	public static void main(String[] args) {
		int[] list = { 4, 1, 2, 5, 6, 7, 3 };
		// top k largest
		System.out.println("前3个最大的数字" + findLargest(list, 3)); // 第3个大的数字
	}
	
	// 解决top k问题 - 堆排序,最直观：小顶堆
	// top K largest
	public static PriorityQueue<Integer> findLargest(int[] nums, int k) {
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
		for (int num : nums) {
			if (minQueue.size() < k || num > minQueue.peek()) // 返回小顶堆根的数字
				minQueue.offer(num); // 在末尾添加数字
			if (minQueue.size() > k)
				minQueue.poll(); // 移出根顶堆的数字
		}
		return minQueue;
	}

}
