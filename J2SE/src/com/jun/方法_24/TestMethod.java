package com.jun.方法_24;

/*
 * 测试 方法
 */
public class TestMethod {
	
	//测试方法retrun
	public int sum(int a,int b){
		int sum =0;
		if (a==3){
			return 0; //如果a等于3,结束 方法运行，之后的语句就 不执行了 
		}
		sum = a+b;
		System.out.println("sum= "+sum);
		return sum;
	}
	
	//测试方法 -值传递
	private void test1(int a){
        a = 5;
        System.out.println("test1方法中的a="+a);
   }
	
	//测试方法-引用传递
	private void test1(A a){
         a.age = 20;
         System.out.println("test1方法中的age="+a.age);
     }
			
	public static void main(String[] args) {
		
		//测试方法return
		new TestMethod().sum(1, 2);
		new TestMethod().sum(3, 2);
		
		//调用值传递
		int a = 3;
		new TestMethod().test1(a);//传递后，test1方法对变量值的改变不影响这里的a
		System.out.println("main方法中的a="+a);
		
		//调用引用传递
		A a1 = new A();
        a1.age = 10;
        new TestMethod().test1(a1);
        System.out.println("main方法中的age="+a1.age);
	}

}

class A{
    public int age = 0;
}
