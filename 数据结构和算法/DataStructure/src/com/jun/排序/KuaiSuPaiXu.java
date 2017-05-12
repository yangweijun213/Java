package com.jun.排序;

public class KuaiSuPaiXu {
	
	public static void main(String[] args) {
		int[] list = { 8,7,6,5 };
		funQuickSort(list,0,list.length-1);
		
		for (int i=0;i<list.length;i++)
			System.out.println(i);
	}

	
	// 快速排序
	static void funQuickSort(int[] mdata, int start, int end) {
	    if (end > start) {
	        int pivotIndex = quickSortPartition(mdata, start, end);
	        funQuickSort(mdata, start, pivotIndex - 1);
	        funQuickSort(mdata, pivotIndex + 1, end);
	    }
	}

	// 快速排序前的划分
	static int quickSortPartition(int[] list, int first, int last) {

	    int pivot = list[first];
	    int low = first + 1;
	    int high = last;

	    while (high > low) {

	        while (low <= high && list[low] <= pivot) {
	            low++;
	        }

	        while (low <= high && list[high] > pivot) {
	            high--;
	        }

	        if (high > low) {
	            int temp = list[high];
	            list[high] = list[low];
	            list[low] = temp;
	        }
	    }

	    while (high > first && list[high] >= pivot) {
	        high--;
	    }

	    if (pivot > list[high]) {
	        list[first] = list[high];
	        list[high] = pivot;
	        return high;
	    } else {
	        return first;
	    }
	}
	
	

}
