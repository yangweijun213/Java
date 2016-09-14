package priv.practices.Java继承和多态;



/**
 * @author http://www.weixueyuan.net/view/6001.html
 * Java instanceof 运算符
 * instanceof 运算符用来判断一个变量所引用的对象的实际类型
 */


//可以看出，如果变量引用的是当前类或它的子类的实例，instanceof 返回 true，否则返回 false。
public final class Demo09{
    public static void main(String[] args) {
        // 引用 People 类的实例
        People09 obj = new People09();
        if(obj instanceof Object){
            System.out.println("我是一个对象");
        }
        if(obj instanceof People09){
            System.out.println("我是人类");
        }
        if(obj instanceof Teacher09){
            System.out.println("我是一名教师");
        }
        if(obj instanceof President09){
            System.out.println("我是校长");
        }
        System.out.println("-----------");  // 分界线
       
        // 引用 Teacher 类的实例
        obj = new Teacher09();
        if(obj instanceof Object){
            System.out.println("我是一个对象");
        }
        if(obj instanceof People09){
            System.out.println("我是人类");
        }
        if(obj instanceof Teacher09){
            System.out.println("我是一名教师");
        }
        if(obj instanceof President09){
            System.out.println("我是校长");
        }
    }
}
class People09{ }
class Teacher09 extends People09{ }
class President09 extends Teacher09{ }
