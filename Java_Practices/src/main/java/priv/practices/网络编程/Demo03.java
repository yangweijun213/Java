package priv.practices.网络编程;

import java.io.*;
import java.net.*;

/**
 * @author http://www.weixueyuan.net/view/6080.html
 * Java 套接字(Socket)
 */


//C/S模式中的Client端应用程序。这是一个Client端的流式Socket通信的简单实例，代码说明Client端程序的编写方法。例中，Client程序向服务器主机的端口4441提出请求，连接建立后完成对服务器的读写
public class Demo03 {

	public static void main(String args[]){
        String s = null;Socket mySocket;
        DataInputStream in = null;DataOutputStream out = null;
        try{
            mySocket = new Socket("localhost",80);
            in = new DataInputStream(mySocket.getInputStream());
            out = new DataOutputStream(mySocket.getOutputStream());
            out.writeUTF("good server!");
            while(true){
                s = in.readUTF();
                if(s==null) break;
                else System.out.println(s);
            }
            mySocket.close();
        }catch(IOException e){
            System.out.println("can’t connect");
        }
        
	}

}
