package priv.practices.Java继承和多态;


/**
 * @author http://www.weixueyuan.net/view/5998.html
 * Java Super
 * 调用父类的构造方法 
 */

/*在构造方法中调用另一个构造方法，调用动作必须置于最起始的位置。
不能在构造方法以外的任何方法内调用构造方法。
在一个构造方法内只能调用一个构造方法。
最后注意 super 与 this 的区别：super 不是一个对象的引用，不能将 super 赋值给另一个对象变量，它只是一个指示编译器调用父类方法的特殊关键字。
*/
public class Demo03{
    public static void main(String[] args) {
        Dog02 obj = new Dog02("花花", 3);
        obj.say();
    }
}
class Animal02{
    String name;
    
    public Animal02(String name){
        this.name = name;
    }
}
class Dog02 extends Animal02{
    int age;
    
    //调用父类的 构造方法
    public Dog02(String name, int age){
       
    	//子类的构造过程中必须调用父类的构造方法,等同于super name = name;
    	super(name);
        this.age = age;
    }
    public void say(){
        System.out.println("我是一只可爱的小狗，我的名字叫" + name + "，我" + age + "岁了");
    }
}
