package priv.practices.Java继承和多态;


/**
 * @author http://www.weixueyuan.net/view/5996.html
 * 继承的概念与实现
 * 在类继承中，子类可以修改从父类继承来的方法，也就是说子类能创建一个与父类方法有不同功能的方法，但具有相同的名称、返回值类型、参数列表。
 */

/*对程序的说明

name 和 age 变量虽然没有在 Teacher 中定义，但是已在 People 中定义，可以直接拿来用。
Teacher 是 People 的子类，People 是Teacher 类的父类。
子类可以覆盖父类的方法。
子类可以继承父类除private以为的所有的成员。
构造方法不能被继承。*/

public class Demo01 {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.name = "小布";
        t.age = 70;
        t.school = "清华大学";
        t.subject = "Java";
        t.seniority = 12;
        t.say();
        t.lecturing();
    }
}
class People{
    String name;
    int age;
    int height;
   
    void say(){
        System.out.println("我的名字是 " + name + "，年龄是 " + age + "，身高是 " + height);
    }
}

//继承 People 类的成员，再增加自己的成员即可
class Teacher extends People{
    String school;  // 所在学校
    String subject;  // 学科
    int seniority;  // 教龄
   
    // 覆盖 People 类中的 say() 方法
    void say(){
        System.out.println("我叫" + name + "，在" + school + "教" + subject + "，有" + seniority + "年教龄");
    }
   
    void lecturing(){
        System.out.println("我已经" + age + "岁了，依然站在讲台上讲课");
    }
    
    
}