package com.jun.top_k;

import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {

		int[] list = { 19, 11, 12, 13, 18, 17, 16, 15, 14, 10 };
		// 从10个数字的文本中，找出最大的前3个
		for (int k = 3; k > 0; k--) {
			System.out.println(findKthLargest(list, k));
		}
	}

	// 解决top k问题 - 堆排序
	// 最直观：小顶堆（大顶堆 -> 最小100个数）
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
		for (int num : nums) {
			if (minQueue.size() < k || num > minQueue.peek()) //minQueue.peek()取的是minQueue最小的那个数
				minQueue.offer(num);
			if (minQueue.size() > k)
				minQueue.poll();
		}
		return minQueue.peek();
	}

}
