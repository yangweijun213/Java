package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/view/6046.html
 * Java面向字节流的应用 - 过滤流: 读取数据文件 demo07.dat 中的三个 int 型数字，求和并显示。
 */
public class Demo09 {

	public static void main(String args[]) throws IOException{
        DataInputStream a=new DataInputStream(System.in);
        System.out.print("请输入一个整数：");
        int b=a.readInt();
        int sum=0;
        int c=b;
        while(c>0){
            int d=c%10;  //取最低位
            c=c/10;  //去掉最低位
            sum=sum+d;  //累加各位之和
        }
        System.out.println(b+"的各位数字之和="+sum);
    }
}
