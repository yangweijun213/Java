package cn.bjsxt.oop.testInterface;

public class MyClass implements MyInterface {

	@Override
	public void test01() {
		System.out.println(MyInterface.MAX_GRADE); //接口定义的常量
		System.out.println("test01");
		
	}

	@Override
	public int test02(int a, int b) {
		System.out.println("MyCLass.test02()");
		return 0;
	}

}
