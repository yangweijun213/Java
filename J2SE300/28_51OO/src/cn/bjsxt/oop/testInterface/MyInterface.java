package cn.bjsxt.oop.testInterface;

public interface MyInterface {
	//接口中只有：变量，抽象方法
	/*public static final 接口中常量定义时，写或不写都是这样*/String MAX_GRADE ="BOSS";
	int MAX_SPEED = 120;
	
	/*public abstract*/ void test01();
	public int test02(int a, int b);
}
