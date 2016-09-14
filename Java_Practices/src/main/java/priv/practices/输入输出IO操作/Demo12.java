package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/view/6048.html
 * 文件的随机读写 - Java中文件的随机读写: 模仿系统日志，将数据写入到文件尾部
 */

public class Demo12 {
	public static void main(String args[]) throws IOException{
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            String s=in.readLine();
            RandomAccessFile myFile=new RandomAccessFile("demo12.log","rw");
            myFile.seek(myFile.length());  //移动到文件结尾
            myFile.writeBytes(s+"\n");  //写入数据
            myFile.close();
        }
        catch(IOException e){}
    }

}
