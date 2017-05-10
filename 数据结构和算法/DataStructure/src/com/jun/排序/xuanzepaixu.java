package com.jun.排序;

public class xuanzepaixu {

	public static void main(String[] args) {
		int[] array ={3,2,1};
		funSelectionSort (array);
	}
	
	// 选择排序 - 从小到大
	static void funSelectionSort(int[] array) {
		int iteration =0;
		
		for (int i = 0; i < array.length - 1; i++) {

			int mink = i;

		    iteration = iteration+1;
			System.out.println("iteration" + iteration);
					
			// 每次从未排序数组中找到最小值的坐标
			for (int j = i + 1; j < array.length; j++) {
			    iteration = iteration+1;
				System.out.println("iteration" + iteration);
				if (array[j] < array[mink]) {
					mink = j;
				}
			}

			// 将最小值放在最前面
			if (mink != i) {
				int temp = array[mink];
				array[mink] = array[i];
				array[i] = temp;
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
