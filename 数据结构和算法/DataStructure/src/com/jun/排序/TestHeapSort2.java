package com.jun.排序;

import java.util.Arrays;

public class TestHeapSort2 {

	public static void main(String[] args) {
        String str = "asdfgh";
        char[] arr=str.toCharArray();
        int length = arr.length;
        heapsort(arr, length);
        System.out.println(Arrays.toString(arr));
    }
	
	//堆排序 - 字符串从小到大
    static void heapsort(char arr[], int n) {
        // 先建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, n);
        }
        for (int i = 0; i < n - 1; i++) {
            swap(arr, 0, n - i - 1);
            heapAdjust(arr, 0, n - i - 1);
        }
    }

    // 交换两个数
    static void swap(char arr[], int low, int high) {
        char temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    // 调整堆
    static void heapAdjust(char arr[], int index, int n) {

        char temp = arr[index];
        int child = 0;
        while (index * 2 + 1 < n) {
            child = index * 2 + 1;
            // child为左右孩子中较大的那个
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++;
            }
            // 如果指定节点大于较大的孩子 不需要调整
            if (temp > arr[child]) {
                break;
            } else {
                // 否则继续往下判断孩子的孩子 直到找到合适的位置
                arr[index] = arr[child];
                index = child;
            }
        }

        arr[index] = temp;
    }
}
