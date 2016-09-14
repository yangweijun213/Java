package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/view/6046.html
 * Java面向字节流的应用 - 标准输入输出: 输入一串字符显示出来，并显示 System.in 和 System.out 所属的类。。
 */

//需要注意的是，输入了 3 个字符按回车后，输出的结果显示为 5 个字符。这是由于 Java 中回车被当作两个字符，一个是 ASCⅡ为 13 的回车符，一个是值为 10 的换行符

public class Demo10 {
	public static void main(String args[]){
        try{
            byte a[]=new byte[128];  //设置输入缓冲区
            System.out.print("请输入字符串：");
            int count =System.in.read(a);  //读取标准输入输出流
            System.out.println("输入的是：");
            for(int i=0;i<count;i++)
               System.out.print(a[i]+"");  //输出数组元素的 ASCII 值
            System.out.println();
            for(int i=0;i<count-2;i++)  //不显示回车和换行符
                System.out.print((char)a[i]+"");  //按字符方式输出元素
            System.out.println();
            System.out.println("输入的字符个数为："+count);
            Class InClass=System.in.getClass();
            Class OutClass=System.out.getClass();
            System.out.println("in 所在的类为："+InClass.toString());
            System.out.println("out 所在的类为："+OutClass.toString());
        }
        catch(IOException e){}
    }
}
