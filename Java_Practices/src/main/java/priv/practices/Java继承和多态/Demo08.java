package priv.practices.Java继承和多态;

/**
 * @author http://www.weixueyuan.net/view/6000.html Java多态和动态绑定 - 动态绑定
 * 
 */

public class Demo08 {
	
	/* 动态绑定
	 为了理解多态的本质，下面讲一下Java调用方法的详细流程。

	 1) 编译器查看对象的声明类型和方法名。

	 假设调用 obj.func(param)，obj 为 Cat 类的对象。需要注意的是，有可能存在多个名字为func但参数签名不一样的方法。例如，可能存在方法 func(int) 和 func(String)。编译器将会一一列举所有 Cat 类中名为func的方法和其父类 Animal 中访问属性为 public 且名为func的方法。

	 这样，编译器就获得了所有可能被调用的候选方法列表。

	 2) 接下来，编泽器将检查调用方法时提供的参数签名。

	 如果在所有名为func的方法中存在一个与提供的参数签名完全匹配的方法，那么就选择这个方法。这个过程被称为重载解析(overloading resolution)。例如，如果调用 func("hello")，编译器会选择 func(String)，而不是 func(int)。由于自动类型转换的存在，例如 int 可以转换为 double，如果没有找到与调用方法参数签名相同的方法，就进行类型转换后再继续查找，如果最终没有匹配的类型或者有多个方法与之匹配，那么编译错误。

	 这样，编译器就获得了需要调用的方法名字和参数签名。

	 3) 如果方法的修饰符是private、static、final（static和final将在后续讲解），或者是构造方法，那么编译器将可以准确地知道应该调用哪个方法，我们将这种调用方式 称为静态绑定(static binding)。

	 与此对应的是，调用的方法依赖于对象的实际类型， 并在运行时实现动态绑。例如调用 func("hello")，编泽器将采用动态绑定的方式生成一条调用 func(String) 的指令。

	 4)当程序运行，并且釆用动态绑定调用方法时，JVM一定会调用与 obj 所引用对象的实际类型最合适的那个类的方法。我们已经假设 obj 的实际类型是 Cat，它是 Animal 的子类，如果 Cat 中定义了 func(String)，就调用它，否则将在 Animal 类及其父类中寻找。

	 每次调用方法都要进行搜索，时间开销相当大，因此，JVM预先为每个类创建了一个方法表(method lable)，其中列出了所有方法的名称、参数签名和所属的类。这样一来，在真正调用方法的时候，虚拟机仅查找这个表就行了。在上面的例子中，JVM 搜索 Cat 类的方法表，以便寻找与调用 func("hello") 相匹配的方法。这个方法既有可能是 Cat.func(String)，也有可能是 Animal.func(String)。注意，如果调用super.func("hello")，编译器将对父类的方法表迸行搜索。

	 假设 Animal 类包含cry()、getName()、getAge() 三个方法，那么它的方法表如下：
	 cry() -> Animal.cry()
	 getName() -> Animal.getName()
	 getAge() -> Animal.getAge()

	 实际上，Animal 也有默认的父类 Object（后续会讲解），会继承 Object 的方法，所以上面列举的方法并不完整。

	 假设 Cat 类覆盖了 Animal 类中的 cry() 方法，并且新增了一个方法 climbTree()，那么它的参数列表为：
	 cry() -> Cat.cry()
	 getName() -> Animal.getName()
	 getAge() -> Animal.getAge()
	 climbTree() -> Cat.climbTree()

	 在运行的时候，调用 obj.cry() 方法的过程如下：

	     JVM 首先访问 obj 的实际类型的方法表，可能是 Animal 类的方法表，也可能是 Cat 类及其子类的方法表。
	     JVM 在方法表中搜索与 cry() 匹配的方法，找到后，就知道它属于哪个类了。
	     JVM 调用该方法。*/


}
