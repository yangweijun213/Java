package com.jun.线性表;

import java.util.Arrays;

public class Array {

	// 数组实现线性表动态增加一个元素
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		System.out.println(Arrays.toString(add (array, 10,5)));	
	}

	/**
	 * @param array 数组
	 * @param e 插入的元素
	 * @param index 插入元素的位置
	 * @return 返回新数组
	 * http://www.jianshu.com/p/230e6fde9c75
	 */
	public static int[] add (int[] array, int e, int index ){
		
		int size = array.length;
		
		//如果index<0 或者 index >size
		if (index <0 ||index >size) {
			System.out.println("不合法");
		}
		
		//如果数组已经满了就扩容
		if (size >=array.length){
			int[] newArray = new int [array.length+1];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
		
		//插入元素
		for (int i = size - 1; i >= index; i--){
			array[i + 1] = array[i];
		}
		array[index] = e;
		size++;
		
		return array;
	}
}
