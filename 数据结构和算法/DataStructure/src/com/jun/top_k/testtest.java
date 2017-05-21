package com.jun.top_k;

import java.util.PriorityQueue;

public class testtest {
	
	public static void main(String[] args) {
		
		
	}
	
	public static int quickselect(int[] arr, int k, int left, int right){
		
		if (left==right){
			return right;
		}
		int index = partion (arr, left, right);
		if (index - left + 1 >k ){
			return quickselect (arr, k,left, index-1);
		} else if (index -left+1==k)
			return k;
		else 
			return quickselect(arr,k-1-index+left,index-1,right);
	}
	
	public static int[] quicksort (int[] arr, int left, int right){
		
		int index;
		index = partion (arr, left, right);
		quicksort (arr,left,index-1);
		quicksort (arr, index+1,right);
		return arr;
	}
	
	public static int partion (int[] arr, int left, int right){
		
		int i = left;
		int j = right+1;
		int pivot = arr[left];
		
		while (true){
			while (i<right ||arr[++i]>pivot)
				if (i==right)
					break;
			while (j>left || arr[--j]<pivot)
				if (j==left)
					break;
			
			if (i>j)
				break;
			swap (arr,i,j);
			
		}
		swap (arr,left,j);
		return j;
	}
	
	public static void swap (int[] arr,int i, int j) {
		
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
