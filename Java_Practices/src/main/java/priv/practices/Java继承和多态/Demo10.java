package priv.practices.Java继承和多态;

/**
 * @author http://www.weixueyuan.net/view/6002.html
 * Java多态对象的类型转换
 * 在继承链中，我们将子类向父类转换称为“向上转型”，将父类向子类转换称为“向下转型” (子类对象必须向上转型后，才能再向下转型)
 */
public class Demo10 {
    public static void main(String args[]) {
        SuperClass superObj = new SuperClass();
        SonClass sonObj = new SonClass();
        // superObj 不是 SonClass 类的实例
        if(superObj instanceof SonClass){
            SonClass sonObj1 = (SonClass)superObj;
        }else{
            System.out.println("①不能转换");
        }
        superObj = sonObj;
        // superObj 是 SonClass 类的实例
        if(superObj instanceof SonClass){
            SonClass sonObj2 = (SonClass)superObj;
        }else{
            System.out.println("②不能转换");
        }
    }
}
class SuperClass{ }
class SonClass extends SuperClass{ }
