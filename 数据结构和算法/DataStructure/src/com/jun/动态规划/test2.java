package com.jun.动态规划;

public class test2 {

	public static void main(String[] args) {
		String x ="ABCBDAB";
		String y = "BDCABA";
		
		int[][]b=lcs(x,y);
		Display(b,x,x.length()-1,y.length()-1);
	}

	// 动态算法 - 最长公共子串
	public static int[][] lcs(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int result = 0; // 记录最长公共子串长度
		int c[][] = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 || j == 0) {
					c[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
					//最长公共子串的长度
					result = Math.max(c[i][j], result);
				} else {
					c[i][j] = 0;
				}
			}
		}
		return c;
	}
	
	public static void Display(int[][]b,String x,int i,int j){
		if(i==0||j==0)
			return;
			if(b[i][j]==1){
				Display(b,x,i-1,j-1);
				System.out.print(x.charAt(i)+"");
				}
			else if(b[i][j]==0){
				Display(b,x,i-1,j);
			}
			else if(b[i][j]==-1){
				Display(b,x,i,j-1);
			}
		}

}
