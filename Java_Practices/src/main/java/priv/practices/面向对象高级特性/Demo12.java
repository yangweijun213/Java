package priv.practices.面向对象高级特性;

/**
 * @author http://www.weixueyuan.net/view/6008.html
 * Java泛型详解 - 定义泛型方法
 *
 */

public class Demo12 {
    public static void main(String[] args){
        // 实例化泛型类
        Point12<Integer, Integer> p1 = new Point12<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        p1.printPoint(p1.getX(), p1.getY());
       
        Point12<Double, String> p2 = new Point12<Double, String>();
        p2.setX(25.4);
        p2.setY("东京180度");
        p2.printPoint(p2.getX(), p2.getY());
    }
}
// 定义泛型类
class Point12<T1, T2>{
    T1 x;
    T2 y;
    public T1 getX() {
        return x;
    }
    public void setX(T1 x) {
        this.x = x;
    }
    public T2 getY() {
        return y;
    }
    public void setY(T2 y) {
        this.y = y;
    }
   
    // 定义泛型方法
    public <T1, T2> void printPoint(T1 x, T2 y){
        T1 m = x;
        T2 n = y;
        System.out.println("This point is：" + m + ", " + n);
    }
}