package com.jun.控制语句_17_18_19_20_21_22_23;

/*
 * 测试循环
 */
public class TestCycle {

	public static void main(String[] args) {

		// 测试while
		int i = 1; // 初始化变量
		while (i < 10) { // 判断
			System.out.println("i= " + i);
			i++; // 迭代
		}

		// 测试for循环
		for (int j = 1; j < 10; j++) {
			System.out.println("J: " + j);
		}
		
		//测试 for(int s : arr) 遍历数组 
		int[] k ={1,2,3,4,5,6};
		for (int m:k) {
			System.out.println("m= "+m);
		}
	}

}
