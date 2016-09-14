package priv.practices.面向对象高级特性;


/**
 * @author http://www.weixueyuan.net/view/6007.html
 * Java静态内部类、匿名内部类、成员式内部类和局部内部类  - 匿名内部类
 */


//匿名类继承了 Person 类并在大括号中实现了抽象类的方法。

abstract class Person {
    public abstract void eat();
}

public class Demo07 {
    public static void main(String[] args){
       
        // 继承 Person 类
        new Person() {
            public void eat() {
                System.out.println("eat something");
            }
        }.eat();
    }
}

