package priv.practices.面向对象高级特性;

/**
 * @author http://www.weixueyuan.net/view/6008.html
 * Java接口(interface)的概念及使用
 *
 */

//在抽象类中，可以包含一个或多个抽象方法；但在接口(interface)中，所有的方法必须都是抽象的，不能有方法体，它比抽象类更加“抽象”。
//接口使用 interface 关键字来声明，可以看做是一种特殊的抽象类，可以指定一个类必须做什么，而不是规定它如何去做。


import static java.lang.System.*;
public class Demo09{
  public static void main(String[] args) {
      SataHdd sh1=new SeagateHdd(); //初始化希捷硬盘
      sh1.writeData("希捷硬盘写入数据");
      
      SataHdd sh2=new SamsungHdd(); //初始化三星硬盘
      sh1.writeData("三星硬盘写入数据");
  }
}
//串行硬盘接口
interface SataHdd{
    //连接线的数量
    public static final int CONNECT_LINE=4;
    //写数据
    public void writeData(String data);
    //读数据
    public String readData();
}
// 维修硬盘接口
interface fixHdd{
    // 维修地址
    String address = "北京市海淀区";
    // 开始维修
    boolean doFix();
}
//希捷硬盘
class SeagateHdd implements SataHdd, fixHdd{
    //希捷硬盘读取数据
    public String readData(){
        return "数据";
    }
    //希捷硬盘写入数据
    public void writeData(String data) {
        out.println("写入成功");
    }
    // 维修希捷硬盘
    public boolean doFix(){
        return true;
    }
}
//三星硬盘
class SamsungHdd implements SataHdd{
    //三星硬盘读取数据
    public String readData(){
        return "数据";
    }
    //三星硬盘写入数据
    public void writeData(String data){
        out.println("写入成功");
    }
}
//某劣质硬盘，不能写数据
abstract class XXHdd implements SataHdd{
    //硬盘读取数据
    public String readData() {
        return "数据";
    }
}
