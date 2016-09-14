package priv.practices.Java异常处理基础;

/**
 * @author http://www.weixueyuan.net/view/6019.html Java throws
 */
public class Demo03 {

	// 为编译该程序，需要改变两个地方。第一，需要声明throwOne( )引发IllegalAccess Exception异常。第二，main(
	// )必须定义一个try/catch 语句来捕获该异常。正确的例子如下：
	// This is now correct.

	static void throwOne() throws IllegalAccessException {
		System.out.println("Inside throwOne.");
		throw new IllegalAccessException("demo");
	}

	public static void main(String args[]) {
		try {
			throwOne();
		} catch (IllegalAccessException e) {
			System.out.println("Caught " + e);
		}
	}

}
