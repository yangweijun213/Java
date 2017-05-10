package com.jun.排序;

public class MaoPao {

	public static void main(String[] args) {
		int[] list = { 7, 6, 5, 4, 3, 2, 1 };
		int[] list2 = { 1, 2, 3, 4, 5, 6, 7 };
		funBubbleSort(list2);
	}

	// 冒泡排序 - 从小到大排序
	// 2个for循环，相邻元素间相互比较，将最大的值依次冒出, 下次减少一次。
	// 时间复杂度: 最快是O(n): 最慢是 O(n^2)
	// 冒泡排序 注意 flag 的作用. 就是在进行一次大遍历后，还是没有交换位置的话，就不用进行下个大遍历了
	static void funBubbleSort(int[] array) {

		boolean flag = true;
		int interation =0;
	
		for (int i = 0; i < array.length - 1 && flag; i++) {
			flag = false;
			interation = interation+1;
			System.out.println("interation:"+interation);
			
			for (int j = 0; j < array.length - 1 - i; j++) {
				interation = interation+1;
				System.out.println("interation:"+interation);
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = true;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
