package priv.practices.面向对象高级特性;

/**
 * @author http://www.weixueyuan.net/view/6007.html
 * Java静态内部类、匿名内部类、成员式内部类和局部内部类  - 成员式内部类的访问
 */

public class Outer05{
    private int size;
    public class Inner05{
        private int size;
        public void dostuff(int size){
            size++;  // 局部变量 size;
          //  this.size;  // 内部类的 size
            Outer05.this.size++;  // 外部类的 size
        }
    }
}