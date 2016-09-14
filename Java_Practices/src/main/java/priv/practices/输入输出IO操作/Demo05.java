package priv.practices.输入输出IO操作;
import java.io.*;

/**
 * @author http://www.weixueyuan.net/view/6046.html
 * Java面向字节流的应用 - 通过程序创建一个文件，从键盘输入字符，当遇到字符“#”时结束，在屏幕上显示该文件的所有内容。
 */
public class Demo05 {
	public static void main(String args[]){
        char ch;
        int data;
        try{
            FileInputStream a=new FileInputStream(FileDescriptor.in);  //创建文件输入流对象
            FileOutputStream b=new FileOutputStream("demo05.txt");  //创建文件输出流对象
            System.out.println("请输入字符，以#号结束：");
            while((ch=(char)a.read())!='#'){
                b.write(ch);
            }
            a.close();
            b.close();
            System.out.println();
            FileInputStream c=new FileInputStream("demo05.txt");
            FileOutputStream d=new FileOutputStream(FileDescriptor.out);
            while(c.available()>0){
               data=c.read();
               d.write(data);
           }
           c.close();d.close();
       }
       catch(FileNotFoundException e){
          System.out.println("找不到该文件！");
       }
       catch(IOException e){}
    }
}
