package com.bjsxt.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DispatchSocket implements Runnable {

	private static SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Socket socket;
	public DispatchSocket(Socket socket){
		this.socket =socket;
	}
	
	public void run() {
		try{
			System.out.println("客户端是："+socket.getRemoteSocketAddress());
			//获取客户端发送给服务器的数据的输入流
			Request request =new Request(socket.getInputStream(),8080);
			Response response =new Response(socket.getOutputStream());
			//往客户端发送一个html
			String html="<html ><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\" />" +
					"</head>" +
					"<body>" +
					"<h2>通信服务测试信息</h2>" +
					"<h2>服务器当前时间是："+SDF.format(new Date())+"</h2>" +
					"</body></html>";
			response.print(html);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeSocket(socket);
		}
	}

	public void closeSocket(Socket socket){
		if(socket!=null)
			try {
				socket.getOutputStream().flush();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
