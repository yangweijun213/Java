package cn.sxt.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("username======="+req.getParameter("username"));
		//定义一个磁盘文件目录工厂   参数分别为：缓存大小  临时文件目录
		DiskFileItemFactory dif = new DiskFileItemFactory(4096, new File("c:/"));
		//ServletFileUpload 根据工厂来创建
		ServletFileUpload fu = new ServletFileUpload(dif);
		try {
			//解析文件上传的request对象
			//一个FileItem 对应表单中一个表单项
			List<FileItem> list = fu.parseRequest(req);
			for(FileItem fi:list){
				//判断是否是普通的表单项
				if(fi.isFormField()){
					//getFieldName 获取表单域名称
					//getString 获取表单域的值
					System.out.println(fi.getFieldName()+"-----"+fi.getString());
				}else{//文件上传的文件项
					//获取上传文件的位置
					String path = req.getRealPath("/upload");
					//获取文件名
					String filename=fi.getName();
					if(filename.lastIndexOf("\\")>0){
						filename=filename.substring(filename.lastIndexOf("\\")+1);
					}
					fi.write(new File(path,filename));
					//fi.getInputStream();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
