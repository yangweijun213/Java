package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/uploads/code/java/rumen/10-1.txt
 * 利用 FileWriter 类将 ASCⅡ字符写入到文件中
 */
public class Demo03 {
	public static void main(String args[]){
        try{
            FileWriter a=new FileWriter("demo03.txt");
            //将abcd输出到demo03.txt
            a.write("abcd");
            
            //将!"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}输出
            /*for(int i=32;i<126;i++){
                a.write(i);
            }*/
            a.close();
        }
        catch(IOException e){}
    }

}
