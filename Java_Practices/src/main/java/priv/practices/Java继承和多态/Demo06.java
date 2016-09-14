package priv.practices.Java继承和多态;

/**
 * @author http://www.weixueyuan.net/view/6000.html
 * Java多态和动态绑定 - 多态
           多态存在的三个必要条件：要有继承、要有重写、父类变量引用子类对象。
           在Java中，父类的变量可以引用父类的实例，也可以引用子类的实例
 * 
 */


public class Demo06 {
	public static void main(String[] args){
        Animal06 obj = new Animal06();
        obj.cry();
        
      //在Java中，父类的变量可以引用父类的实例，也可以引用子类的实例。
        obj = new Cat06();
        obj.cry();
        obj = new Dog06();
        obj.cry();
    }
}
class Animal06{
    // 动物的叫声
    public void cry(){
        System.out.println("不知道怎么叫");
    }
   
}
class Cat06 extends Animal06{
    // 猫的叫声
    public void cry(){
        System.out.println("喵喵~");
    }
}
class Dog06 extends Animal06{
    // 狗的叫声
    public void cry(){
        System.out.println("汪汪~");
    }
}
