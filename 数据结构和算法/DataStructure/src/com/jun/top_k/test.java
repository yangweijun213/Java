package com.jun.top_k;

import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		int[] list = { 4, 1, 2, 5, 6, 7, 3 };
		// top 3th
		System.out.println("第3个大的数字" + findKthLargest(list, 3));
	}

	// 解决top k问题 - 堆排序,最直观：小顶堆
	// KthLargest
	// 参考: http://www.cnblogs.com/en-heng/p/6336625.html
	// 最好O(nlogn)，最坏O(nlogn)，平均O(nlogn)，空间复杂度为O(1) http://www.jianshu.com/p/42f81846c0fb
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
		for (int num : nums) {
			if (minQueue.size() < k || num > minQueue.peek()) // minQueue.peek() 返回最小顶堆根
				minQueue.offer(num); // 在末尾添加
			if (minQueue.size() > k)
				minQueue.poll(); // 移出最小顶堆根
		}
		return minQueue.peek(); // 返回KthLargest
	}
}
