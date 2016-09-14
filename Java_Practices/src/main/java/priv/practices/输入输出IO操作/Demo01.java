package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/uploads/code/java/rumen/10-1.txt
 * 利用 FileReader 类读取纯文本文件的内容
 */
public class Demo01 {
	
	public static void main(String args[]) throws IOException{
		
        char a[]=new char[1000]; //创建可容纳 1000 个字符的数组
        FileReader b=new FileReader("demo01.txt"); //在src目录平行的位置，新建文件demo01.txt, 保存为utf-8
        int num=b.read(a); //将数据读入到数组 a 中，并返回字符数
        String str=new String(a,0,num); //将字符串数组转换成字符串
        System.out.println("读取的字符个数为："+num+",内容为：\n");
        System.out.println(str);
    }

}
