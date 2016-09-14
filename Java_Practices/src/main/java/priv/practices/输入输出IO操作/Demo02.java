package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/uploads/code/java/rumen/10-1.txt
 * 使用 BufferedReader 类读取文件
 */
public class Demo02 {
	 public static void main(String args[]) throws IOException{
	        String OneLine;
	        int count=0;
	        try{
	                FileReader a=new FileReader("demo01.txt");
	                BufferedReader b=new BufferedReader(a);
	                while((OneLine=b.readLine())!=null){  //每次读取 1 行
	                     count++;  //计算读取的行数
	                     System.out.println(OneLine);
	                }
	                System.out.println("\n 共读取了"+count+"行");
	                b.close();
	           }
	           catch(IOException io){
	                System.out.println("出错了!"+io);
	           }
	      }
}
