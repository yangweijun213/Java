package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/view/6046.html
 * Java面向字节流的应用 - 实现对二进制图形文件（.gif）的备份。
 */
public class Demo06 {
	public static void main(String args[]) throws IOException{
        FileInputStream a=new FileInputStream("ep10_6.gif");
        FileOutputStream b=new FileOutputStream("ep10_6_a.gif");
        System.out.println("文件的大小为："+a.available());
        byte c[]=new byte[a.available()];
        a.read(c);  //将图形文件读入数组
        b.write(c);  //将数组中的数据写入到新文件中
        System.out.println("文件已经被更名复制！");
        a.close();
        b.close();
    }
}
