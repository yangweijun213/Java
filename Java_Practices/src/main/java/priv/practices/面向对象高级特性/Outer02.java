package priv.practices.面向对象高级特性;


/**
 * @author http://www.weixueyuan.net/view/6007.html
 * Java静态内部类、匿名内部类、成员式内部类和局部内部类  - 成员式内部类
 */


/*在外部类内部直接定义（不在方法内部或代码块内部）的类就是成员式内部类，它可以直接使用外部类的所有变量和方法，即使是 private 的。外部类要想访问内部类的成员变量和方法，则需要通过内部类的对象来获取。
成员式内部类如同外部类的一个普通成员。
成员式内部类可以使用各种修饰符，包括 public、protected、private、static、final 和 abstract，也可以不写。
若有 static 修饰符，就为类级，否则为对象级。类级可以通过外部类直接访问，对象级需要先生成外部的对象后才能访问。
非静态内部类中不能声明任何 static 成员。*/

public class Outer02{
    private int size;
    
    //成员式内部类
    public class Inner02 {
        public void dostuff() {
            size++;
        }
    }
    public void testTheInner() {
        Inner02 in = new Inner02();
        in.dostuff();
    }
}
