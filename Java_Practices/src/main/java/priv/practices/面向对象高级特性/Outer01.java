package priv.practices.面向对象高级特性;


/**
 * @author http://www.weixueyuan.net/view/6006.html
 * Java内部类及其实例化 - 内部类
 * 允许在一个类（或方法、语句块）的内部定义另一个类，这个类称为内部类(Inner Class)
 */

/*这段代码定义了一个外部类 Outer，它包含了一个内部类 Inner。将错误语句注释掉，编译，会生成两个 .class 文件：Outer.class 和 Outer$Inner.class。也就是说，内部类会被编译成独立的字节码文件。
内部类是一种编译器现象，与虚拟机无关。编译器将会把内部类翻译成用 $ 符号分隔外部类名与内部类名的常规类文件，而虚拟机则对此一无所知。
注意：必须先有外部类的对象才能生成内部类的对象，因为内部类需要访问外部类中的成员变量，成员变量必须实例化才有意义。*/

public class Outer01 {
    private int size;
    public class Inner01 {
        private int counter = 10;
        public void doStuff() {
        	
        	//内部类可以访问外部类中的数据，包括私有的数据
            size++;
        }
    }
    public static void main(String args[]) {
        Outer01 outer = new Outer01();
        Inner01 inner = outer.new Inner01();
        inner.doStuff();
        System.out.println(outer.size);
        System.out.println(inner.counter);
        // 编译错误，外部类不能访问内部类的变量
       // System.out.println(counter);
    }
}