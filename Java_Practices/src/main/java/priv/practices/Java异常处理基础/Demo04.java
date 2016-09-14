package priv.practices.Java异常处理基础;

/**
 * @author http://www.weixueyuan.net/view/6022.html
 * 使用Java创建自己的异常子类
 */


public class Demo04 {

	static void compute(int a) throws MyException {
	        System.out.println("Called compute(" + a + ")");
	       if(a > 10)
	          throw new MyException(a);
	       System.out.println("Normal exit");
	}

	public static void main(String args[]) {
		try {
			compute(1);
			compute(20);
		} catch (MyException e) {
			System.out.println("Caught " + e);
		}
	}

}
