package priv.practices.面向对象高级特性;



/**
 * @author http://www.weixueyuan.net/view/6008.html
 * Java抽象类的概念和使用
 *
 */

/*
 只给出方法定义而不具体实现的方法被称为抽象方法，抽象方法是没有方法体的，
 在代码的表达上就是没有“{}”。包含一个或多个抽象方法的类也必须被声明为抽象类
 基类就是父类,派生类就是子类
 */

//抽象类不能被实例化，抽象方法必须在子类中被实现

import static java.lang.System.*;
public final class Demo08{
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.setName("王明");
        t.work();
       
        Driver d = new Driver();
        d.setName("小陈");
        d.work();
    }
}
// 定义一个抽象类
abstract class People{
    private String name;  // 实例变量
   
    // 共有的 setter 和 getter 方法
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
   
    // 抽象方法
    public abstract void work();
}
class Teacher extends People{
    // 必须实现该方法
    public void work(){
        out.println("我的名字叫" + this.getName() + "，我正在讲课，请大家不要东张西望...");
    }
}
class Driver extends People{
    // 必须实现该方法
    public void work(){
        out.println("我的名字叫" + this.getName() + "，我正在开车，不能接听电话...");
    }
}
