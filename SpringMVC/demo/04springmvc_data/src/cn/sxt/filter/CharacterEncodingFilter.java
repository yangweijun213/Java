package cn.sxt.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterEncodingFilter implements Filter{
	String encoding=null;
	public void destroy() {
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("filter req:"+request);
		if(encoding==null||"".equals(encoding)){
			encoding="utf-8";
		}
		//解决的post请求
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		HttpServletRequestWrapper req=new HttpServletRequestWrapper((HttpServletRequest) request){
			public String getParameter(String name) {
				//对于get请求特殊处理
				if("get".equals(this.getMethod().toLowerCase())){
					String value=super.getParameter(name);
					try {
						return new String(value.getBytes("iso-8859-1"),encoding);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					return value;
				}
				return super.getParameter(name);
			}
		};
		chain.doFilter(req, response);
	}
}
