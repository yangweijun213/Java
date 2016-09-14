package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/view/6046.html
 * Java面向字节流的应用 - 过滤流: 读取数据文件 demo07.dat 中的三个 int 型数字，求和并显示。
 */
public class Demo08 {
	public static void main(String args[]){
	String fileName="demo07.dat";
    int sum=0;
    try{
        DataInputStream a=new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        sum+=a.readInt();
        sum+=a.readInt();
        sum+=a.readInt();
        System.out.println("三个数的和为："+sum);
        a.close();
    }
    catch(IOException e){
        System.out.println("出现错误！"+fileName);
    }
}
}
