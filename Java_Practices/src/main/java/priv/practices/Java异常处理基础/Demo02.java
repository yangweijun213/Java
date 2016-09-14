package priv.practices.Java异常处理基础;

/**
 * @author http://wenku.baidu.com/link?url=k2h23JL4cT1koWwwP8CTYWvwXcShLfF7nw4D-
 *         ZME5tn1d8N_AszsRhmzAwhYS7yPEmEeAelxDIxnX0l0LyANhqFOl1WafT8nJkGx8LwabpG
 *         使用throw语句在方法中抛出异常
 */

public class Demo02 {
	public static void main(String args[]) {

		int a = 5, b = 0;

		try {
			if (b == 0)
				throw new ArithmeticException();
			// 抛出异常，不是必须的
			else
				System.out.println(a + "/" + b + "=" + a / b);
			// 若不抛出异常，则运行此行
		}

		catch (ArithmeticException e) {
			System.out.println("异常：" + e + "被抛出了！");
			e.printStackTrace();
			// 显示异常信息

		}
	}

}
