package cn.sxt.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class UploadController {
	//到达上传页面
	@RequestMapping("/toUpload.do")
	public String toUpload(){
		return "forward:upload.jsp";
	}
	//文件上传
	/**
	 * spring mvc封装了上传文件  将其封装为一个file对象
	 * */
	@RequestMapping("/upload.do")
	//必须是 @RequestParam("file") 请求的名称
	public String upload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req){
		//获取上传位置
		String path=req.getRealPath("/upload");
		//获取文件名
		String filename=file.getOriginalFilename();
		//上传文件，需要用到读写流 
		try {
			InputStream is = file.getInputStream();
			OutputStream os = new FileOutputStream(new File(path,filename));
			int len=0;
			byte[] buffer = new byte[400];
			while((len=is.read(buffer))!=-1){
				os.write(buffer, 0, len);
			}
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:index.jsp";
	}
	
	//批量上传只要实现数组就可以
	@RequestMapping("/batch.do")
	public String batch(@RequestParam("file") CommonsMultipartFile file[],HttpServletRequest req){
		//获取上传位置
		String path=req.getRealPath("/upload");
		for(int i=0;i<file.length;i++){
			//获取文件名
			String filename=file[i].getOriginalFilename();
			try {
				InputStream is = file[i].getInputStream();
				OutputStream os = new FileOutputStream(new File(path,filename));
				int len=0;
				byte[] buffer = new byte[400];
				while((len=is.read(buffer))!=-1){
					os.write(buffer, 0, len);
				}
				os.close();
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:index.jsp";
	}
}
