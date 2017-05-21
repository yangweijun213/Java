package com.jun.动态规划;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "cnblogs";
		String str2 = "belong";
		System.out.println(lcs(str1, str2));

	}

	/**
	 * 动态规划 - 求最长公共子序列的数量 (
	 * 
	 * @param str1
	 * @param str2
	 * @return 返回最长公共子序列的个数 http://www.cnblogs.com/en-heng/p/3963803.html
	 */
	public static int lcs(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int c[][] = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 || j == 0) {
					c[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else {
					c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
				}
			}
		}
		return c[len1][len2];
	}

}
