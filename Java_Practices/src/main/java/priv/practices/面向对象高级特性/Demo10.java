package priv.practices.面向对象高级特性;

/**
 * @author http://www.weixueyuan.net/view/6008.html
 * Java接口(interface)的概念及使用
 *
 */

//接口作为类型使用 - 接口作为引用类型来使用

public class Demo10{
    public void test1(A a) {
        a.doSth();
    }
    public static void main(String[] args) {
        Demo10 d = new Demo10();
        
        //接口作为引用类型来使用
        A a = new B();
        d.test1(a);
    }
}
interface A {
    public int doSth();
}
class B implements A {
    public int doSth() {
        System.out.println("now in B");
        return 123;
    }
}