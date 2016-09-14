package priv.practices.Java继承和多态;

/**
 * @author http://www.weixueyuan.net/view/6051.html
 * Java Object类 - equals(), toString(), hasCode()
 * Object 类位于 java.lang 包中，是所有 Java 类的祖先，Java 中的每个类都由它扩展而来
 *
 */

//定义Java类时如果没有显示的指明父类，那么就默认继承了 Object 类
public class Demo13 {
	
	public static void main (String[] args) {
	//equals() 方法 
	
	/*在通过 equals() 和“==”进行比较的时候，引用类型数据比较的是引用，即内存地址，基本数据类型比较的是值。

	注意：
	equals()方法只能比较引用类型，“==”可以比较引用类型及基本类型。
	当用 equals() 方法进行比较时，对类 File、String、Date 及包装类来说，是比较类型及内容而不考虑引用的是否是同一个实例。
	用“==”进行比较时，符号两边的数据类型必须一致（可自动转换的数据类型除外），否则编译出错，而用 equals 方法比较的两个数据只要都是引用类型即可*/
	
	Demo13 obj1 =new Demo13();
	Demo13 obj2 =new Demo13();
	
	if (obj1.equals(obj2) ) {
		System.out.println("obj1 相同 obj 2");
	}
	
	else {
		System.out.println("obj1 不相同 obj 2");
	}

	
	//hashCode() 方法
	/*散列码(hashCode)是按照一定的算法由对象得到的一个数值，散列码没有规律。如果 x 和 y 是不同的对象，x.hashCode() 与 y.hashCode() 基本上不会相同
	  hashCode() 可以用于对象的比较.
	       如果两个对象被 equals() 方法视为相等，那么对这两个对象调用 hashCode() 必须获得相同的整数结果. 
	       简单地说：如果两个对象相同，那么它们的 hashCode 值一定要相同；如果两个对象的 hashCode 值相同，它们并不一定相同。*/
	
	
	//toString() 方法 - toString() 方法是 Object 类中定义的另一个重要方法，是对象的字符串表现形式, 返回String 类型 . public String toString()
	//http://blog.csdn.net/lee576/article/details/7239242
		
	}

}
