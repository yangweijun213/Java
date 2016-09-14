package priv.practices.面向对象高级特性;

/**
 * @author http://www.weixueyuan.net/view/6007.html
 * Java静态内部类、匿名内部类、成员式内部类和局部内部类  - 成员式内部类的访问
 */

public class Outer06 {
    public static final int TOTAL_NUMBER = 5;
    public int id = 123;
    public void func() {
        final int age = 15;
        String str = "http://www.weixueyuan.net";
        class Inner {
            public void innerTest() {
                System.out.println(TOTAL_NUMBER);
                System.out.println(id);
                // System.out.println(str);不合法，只能访问本地方法的final变量
                System.out.println(age);
            }
        }
        new Inner().innerTest();
    }
    public static void main(String[] args) {
        Outer06 outer = new Outer06();
        outer.func();
    }
    
}