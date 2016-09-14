package priv.practices.Java继承和多态;

/**
 * @author http://www.weixueyuan.net/view/5999.html
 * Java继承中方法的覆盖和重载 - 覆盖
 * 覆盖：如果在新类中定义一个方法，其名称、返回值类型和参数列表正好与父类中的相同，那么，新方法被称做覆盖旧方法
 *     参数列表又叫参数签名，包括参数的类型、参数的个数和参数的顺序，只要有一个不同就叫做参数列表不同。
 *     注意：覆盖不会删除父类中的方法，而是对子类的实例隐藏，暂时不使用
 */

/*方法覆盖的原则：

覆盖方法的返回类型、方法名称、参数列表必须与原方法的相同。
覆盖方法不能比原方法访问性差（即访问权限不允许缩小）。
覆盖方法不能比原方法抛出更多的异常。
被覆盖的方法不能是final类型，因为final修饰的方法是无法覆盖的。
被覆盖的方法不能为private，否则在其子类中只是新定义了一个方法，并没有对其进行覆盖。
被覆盖的方法不能为static。如果父类中的方法为静态的，而子类中的方法不是静态的，但是两个方法除了这一点外其他都满足覆盖条件，那么会发生编译错误；反之亦然。即使父类和子类中的方法都是静态的，并且满足覆盖条件，但是仍然不会发生覆盖，因为静态方法是在编译的时候把静态方法和类的引用类型进行匹配。
*/

public class Demo04{
    public static void main(String[] args) {
        Dog04 myDog = new Dog04("花花");
        myDog.say();  // 子类的实例调用子类中的方法
       
        Animal04 myAnmial = new Animal04("贝贝");
        myAnmial.say();  // 父类的实例调用父类中的方法
    }
}
class Animal04{
    String name;
    public Animal04(String name){
        this.name = name;
    }
   
    public void say(){
        System.out.println("我是一只小动物，我的名字叫" + name + "，我会发出叫声");
    }
}
class Dog04 extends Animal04{
    // 构造方法不能被继承，通过super()调用
    public Dog04(String name){
        super(name);
    }
    // 覆盖say() 方法
    public void say(){
        System.out.println("我是一只小狗，我的名字叫" + name + "，我会发出汪汪的叫声");
        
        // 被覆盖的方法在子类中只能通过super调用。
        super.say();
    }
    

}
