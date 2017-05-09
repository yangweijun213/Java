package 数据结构和算法;

import sun.applet.Main;

public class shellSort {
	
	public static void main(String[] args) {
		
		int[] array ={9,1,2,5,7,4,8,6,3,5};
		shellSort (array);
	}
	
	public static void shellSort(int[] list) {
	    int gap = list.length / 2;
	 
	    while (1 <= gap) {
	        // 把距离为 gap 的元素编为一个组，扫描所有组
	        for (int i = gap; i < list.length; i++) {
	            int j = 0;
	            int temp = list[i];
	 
	            // 对距离为 gap 的元素组进行排序
	            for (j = i - gap; j >= 0 && temp < list[j]; j = j - gap) {
	                list[j + gap] = list[j];
	            }
	            list[j + gap] = temp;
	        }
	 
	        System.out.format("gap = %d:\t", gap);
	        gap = gap / 2; // 减小增量
	    }
	}

}
