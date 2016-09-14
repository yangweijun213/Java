package priv.practices.Java继承和多态;


/**
 * @author http://www.weixueyuan.net/view/5998.html
 * Java Super 关键字
 * 调用父类的隐藏变量, 调用父类的方法和变量
 */

/*super 可以用在子类中，通过点号(.)来获取父类的成员变量和方法。super 也可以用在子类的子类中，Java 能自动向上层类追溯。
通过 super 调用父类的隐藏变量，必须要在父类中声明 getter 方法，因为声明为 private 的数据成员对子类是不可见的。*/

public class Demo02{
    public static void main(String[] args) {
        Dog obj = new Dog();
        obj.move();
    }
}
class Animal{
    private String desc = "Animals are human's good friends";
    String name = "HAHA";
    // 必须要声明一个 getter 方法
    public String getDesc() { return desc; }
    public void move(){
        System.out.println("Animals can move");
    }
}
class Dog extends Animal{
    public void move(){
        super.move();  // 调用父类的方法
        System.out.println("Dogs can walk and run");
        // 通过 getter 方法调用父类隐藏变量
        System.out.println("Please remember: " + super.getDesc());
        
        //调用 父类的属性 
        System.out.println("Name:" +super.name);
    }
}