package ���ݽṹ���㷨;

import sun.applet.Main;

public class shellSort {
	
	public static void main(String[] args) {
		
		int[] array ={9,1,2,5,7,4,8,6,3,5};
		shellSort (array);
	}
	
	public static void shellSort(int[] list) {
	    int gap = list.length / 2;
	 
	    while (1 <= gap) {
	        // �Ѿ���Ϊ gap ��Ԫ�ر�Ϊһ���飬ɨ��������
	        for (int i = gap; i < list.length; i++) {
	            int j = 0;
	            int temp = list[i];
	 
	            // �Ծ���Ϊ gap ��Ԫ�����������
	            for (j = i - gap; j >= 0 && temp < list[j]; j = j - gap) {
	                list[j + gap] = list[j];
	            }
	            list[j + gap] = temp;
	        }
	 
	        System.out.format("gap = %d:\t", gap);
	        gap = gap / 2; // ��С����
	    }
	}

}
