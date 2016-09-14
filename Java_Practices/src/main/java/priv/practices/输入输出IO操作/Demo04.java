package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/uploads/code/java/rumen/10-1.txt
 * 利用 FileWriter 类将 ASCⅡ字符写入到文件中
 */
public class Demo04 {
	public static void main(String args[]){
        String str=new String();
        try{
            BufferedReader in=new
            BufferedReader(new FileReader("demo01.txt"));
            BufferedWriter out=new
            BufferedWriter(new FileWriter("demo03.txt"));
            while((str=in.readLine())!=null){
                System.out.println(str);
                out.write(str);  //将读取到的 1 行数据写入输出流
                out.newLine();  //写入换行符
            }
            out.flush();
            in.close();
            out.close();
        }
        catch(IOException e){
            System.out.println("出现错误"+e);
        }
    }
}
