package priv.practices.Java继承和多态;

/**
 * @author http://www.weixueyuan.net/view/5989.html
 * Java继承中方法的覆盖和重载 - 重载
 * Java父类和子类中的方法都会参与重载，重载就是在一个类中，有相同的函数名称，但形参不同的函数. 
           例如，父类中有一个方法是 func(){ ... }，子类中有一个方法是 func(int i){ ... }，就构成了方法的重载。
           注：形参全称为“形式参数”是在定义函数名和函数体的时候使用的参数，目的是用来接收调用该函数时传递的参数
   
         方法名称相同时，编译器会根据调用方法的参数个数、参数类型等去逐个匹配，以选择对应的方法，如果匹配失败，则编译器报错，这叫做重载分辨。
 */


/*方法的重载的规则：

方法名称必须相同。
参数列表必须不同（个数不同、或类型不同、参数排列顺序不同等）。
方法的返回类型可以相同也可以不相同。
仅仅返回类型不同不足以成为方法的重载。*/

/*覆盖和重载的不同：

方法覆盖要求参数列表必须一致，而方法重载要求参数列表必须不一致。
方法覆盖要求返回类型必须一致，方法重载对此没有要求。
方法覆盖只能用于子类覆盖父类的方法，方法重载用于同一个类中的所有方法（包括从父类中继承而来的方法）。
方法覆盖对方法的访问权限和抛出的异常有特殊的要求，而方法重载在这方面没有任何限制。
父类的一个方法只能被子类覆盖一次，而一个方法可以在所有的类中可以被重载多次。*/

public class Demo05{
    // 一个普通的方法，不带参数
    void test(){
        System.out.println("No parameters");
    }
    // 重载上面的方法，并且带了一个整型参数
    void test(int a){
        System.out.println("a: " + a);
    }
    // 重载上面的方法，并且带了两个参数
    void test(int a,int b){
        System.out.println("a and b: " + a + " " + b);
    }
    // 重载上面的方法，并且带了一个双精度参数
    double test(double a){
        System.out.println("double a: " + a);
        return a*a;
    }
   
    public static void main(String args[]){
        Demo05 obj= new Demo05();
        obj.test();
        obj.test(2);
        obj.test(2,3);
        obj.test(2.0);
    }
}