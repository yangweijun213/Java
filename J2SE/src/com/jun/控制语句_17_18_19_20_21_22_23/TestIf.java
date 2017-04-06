package com.jun.控制语句_17_18_19_20_21_22_23;

public class TestIf {
	
	public static void main(String[] args) {
		
		int a=3;
		//if-else 双选择
		if (a>3){
			System.out.println("a>3");
		}else {
			System.out.println("a<=3");
		}
		
		//if-elseif 多选择
		if (a>3){
			System.out.println("a>3");
		}else if (a==3){
			System.out.println("a=3");
		}else {
			System.out.println("a<3");
		}
	}

}
