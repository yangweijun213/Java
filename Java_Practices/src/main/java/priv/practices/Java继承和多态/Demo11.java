package priv.practices.Java继承和多态;


/**
 * @author http://www.weixueyuan.net/view/6003.html
 * Java static关键字以及Java静态变量和静态方法
          静态变量和静态方法能够通过类名来访问，不需要创建一个类的对象来访问该类的静态成员，所以static修饰的成员又称作类变量和类方法。
          静态变量与实例变量不同，实例变量总是通过对象来访问，因为它们的值在对象和对象之间有所不同。
 */

/*static 内存分配 
静态变量属于类，不属于任何独立的对象，所以无需创建类的实例就可以访问静态变量。之所以会产生这样的结果，是因为编译器只为整个类创建了一个静态变量的副本，也就是只分配一个内存空间，
虽然有多个实例，但这些实例共享该内存。实例变量则不同，每创建一个对象，都会分配一次内存空间，不同变量的内存相互独立，互不影响，改变 a 对象的实例变量不会影响 b 对象
*/

//静态导入 - import static packageName.className.*;  // 导入类中的所有静态成员

/*关于静态变量和静态方法的总结：

一个类的静态方法只能访问静态变量；
一个类的静态方法不能够直接调用非静态方法；
如访问控制权限允许，静态变量和静态方法也可以通过对象来访问，但是不被推荐；
静态方法中不存在当前对象，因而不能使用 this，当然也不能使用 super；
静态方法不能被非静态方法覆盖；
构造方法不允许声明为 static 的；
局部变量不能使用static修饰*/

/*以下情形可以使用静态方法：

一个方法不需要访问对象状态，其所需参数都是通过显式参数提供（例如 Math.pow()）。
一个方法只需要访问类的静态变量。*/

public class Demo11 {
	
    static int i = 10;
    int j;
    
    Demo11() {
        this.j = 20;
    }
    
    static int sum(int x, int y){
        return x + y;
    }
    
    public static void main(String[] args) {
    	
    	//静态变量
        System.out.println("类变量 i=" + Demo11.i);
        Demo11 obj = new Demo11();
        System.out.println("实例变量 j=" + obj.j);
        
        //静态方法
        int sum = Demo11.sum(10, 10);
        System.out.println("10+10=" + sum);
    }

}
