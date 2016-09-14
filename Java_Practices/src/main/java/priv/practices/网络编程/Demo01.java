package priv.practices.网络编程;
import java.net.*;

/**
 * @author http://www.weixueyuan.net/view/6078.html
 * IP地址和InetAddress类  
 */

//Inetaddress类的用法的应用程序。程序演示如何获取www.weixueyuan.net的域名和IP地址
public class Demo01 {
	
	 public static void main(String args[]){
	        try{ //以下代码通过域名建立InetAddress对象：
	            InetAddress addr = InetAddress.getByName("www.weixueyuan.net");
	            String domainName = addr.getHostName();//获得主机名
	            String IPName = addr.getHostAddress();//获得IP地址
	            System.out.println(domainName);
	            System.out.println(IPName);
	        }catch(UnknownHostException e){
	            e.printStackTrace();
	        }
	    }

}
