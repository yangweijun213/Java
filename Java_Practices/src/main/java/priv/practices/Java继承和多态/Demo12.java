package priv.practices.Java继承和多态;


/**
 * @author http://www.weixueyuan.net/view/6004.html
 * Java final关键字：阻止继承和多态
 * final 一般用于修饰那些通用性的功能、实现方式或取值不能随意被改变的数据，以避免被误用，
 * 例如实现数学三角方法、幂运算等功能的方法，以及数学常量π=3.141593、e=2.71828 等。
 */



/*final 修饰的类不能被继承。(不能派生出子类)
final 修饰的方法不能被子类重写。 
final 修饰的变量（成员变量或局部变量）即成为常量，只能赋值一次。
final 修饰的成员变量必须在声明的同时赋值，如果在声明的时候没有赋值，那么只有 一次赋值的机会，而且只能在构造方法中显式赋值，然后才能使用。
final 修饰的局部变量可以只声明不赋值，然后再进行一次性的赋值。*/


/*被 final 修饰的方法为静态绑定，不会产生多态（动态绑定），程序在运行时不需要再检索方法表，能够提高代码的执行效率。在Java中，被 static 或 private 修饰的方法会被隐式的声明为 final，因为动态绑定没有意义。
由于动态绑定会消耗资源并且很多时候没有必要，所以有一些程序员认为：除非有足够的理由使用多态性，否则应该将所有的方法都用 final 修饰。
这样的认识未免有些偏激，因为 JVM 中的即时编译器能够实时监控程序的运行信息，可以准确的知道类之间的继承关系。如果一个方法没有被覆盖并且很短，编译器就能够对它进行优化处理，这个过程为称为内联(inlining)。*/

public final class Demo12{
    
	public static final int TOTAL_NUMBER = 5;
    public int id;
    public Demo12() {
        // 非法，对final变量TOTAL_NUMBER进行二次赋值了
        // 因为++TOTAL_NUMBER相当于 TOTAL_NUMBER=TOTAL_NUMBER+1
      //  id = ++TOTAL_NUMBER;
    }
    
    public static void main(String[] args) {
        final Demo12 t = new Demo12();
        final int i = 10;
        final int j;
        j = 20;
     //   j = 30;  // 非法，对final变量进行二次赋值
    }
}