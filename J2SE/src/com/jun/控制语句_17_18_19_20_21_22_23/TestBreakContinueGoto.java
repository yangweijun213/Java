package com.jun.控制语句_17_18_19_20_21_22_23;

/*
 * 测试break, continue, goto
 */
public class TestBreakContinueGoto {

	public static void main(String[] args) {

		// 测试break
		int i = 1;
		while (true) { // 死循环
			System.out.println("i= " + i);
			i++;
			break; // 终止循环
		}

		// 测试continue
		for (int j = 1; j < 10; j++) {
			if (j == 3) {
				continue;
			}
			System.out.println("j= " + j);
		}

		// 测试goto
		abc: for (int k = 1; k < 10; k++) { // 如果 j等于3，跳到abc标签
			System.out.println("k= " + k);
			for (int j = 1; j < 10; j++) {
				if (j == 3) {
					continue abc;
				}
				System.out.println("j= " + j);
			}
		}
	}

}
