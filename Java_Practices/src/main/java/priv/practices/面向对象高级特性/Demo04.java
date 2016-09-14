package priv.practices.面向对象高级特性;

/**
 * @author http://www.weixueyuan.net/view/6007.html
 * Java静态内部类、匿名内部类、成员式内部类和局部内部类  - 成员式内部类的访问
 */


//使用内部类中定义的非静态变量和方法时，要先创建外部类的对象，再由“outObjectName.new”操作符创建内部类的对象，再调用内部类的方法

public class Demo04{
    public static void main(String[] args) {
        Outer04.Inner04 inner = new Outer04.Inner04();
        inner.dostuff();
    }
}
class Outer04{
    private static int size;
    static class Inner04 {
        public void dostuff() {
            size++;
            System.out.println("size=" + size);
        }
    }
}


