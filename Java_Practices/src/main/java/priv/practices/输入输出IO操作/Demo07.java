package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/view/6046.html
 * Java面向字节流的应用 - 过滤流: 将三个 int 型数字 100，0，-100 写入数据文件 demo07.dat 中。
 */
public class Demo07 {
	public static void main(String args[]){
        String fileName="demo07.dat";
        int value1=100,value2=0,value3=-100;
        try{
            //将 DataOutputStream 与 FileOutputStream 连接输出不同类型的数据
            DataOutputStream a=new DataOutputStream(new FileOutputStream(fileName));
            a.writeInt(value1);
            a.writeInt(value2);
            a.writeInt(value3);
            a.close();
        }
        catch(IOException i){
            System.out.println("出现错误!"+fileName);
        }
    }

}
