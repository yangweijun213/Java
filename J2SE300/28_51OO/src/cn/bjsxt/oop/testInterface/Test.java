package cn.bjsxt.oop.testInterface;

public class Test {
	public static void main(String[] args) {
		Flyable f = new Stone();//只能new 接口子类，接口Flyable 作为类型. 父类引用子类对象
		f.fly();//只能使用Flyable接口定义的MAX_SPEED，MIN_HEIGHT，fly()的属性和方法。与多态是一样的概念（父类引用子类对象）
		
		//如果要使用子类的属性和方法，则必须要转型。
		Stone Stone2 = (Stone)f;
		System.out.println(Stone2.weight); //使用子类定义的属性
		Stone2.run(); //使用子类定义的方法run()
	}

}
