package cn.sxt.interceptor;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter{
	 class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	    public XssHttpServletRequestWrapper(HttpServletRequest request) {
	        super(request);
	        // TODO 自动生成的构造函数存根
	    }
	    @Override
	    public String[] getParameterValues(String parameter) {
	        return super.getParameterValues(parameter);
	    }
	    @Override
	    public String getParameter(String parameter) {
	    	//对于get请求特殊处理
			if("get".equals(this.getMethod().toLowerCase())){
				String value=super.getParameter(parameter);
				try {
					return new String(value.getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return value;
			}
			return super.getParameter(parameter);
	    }
	    @Override
	    public String getHeader(String name) {
	        return super.getHeader(name);
	    }
	    @Override
	    public String getQueryString() {
	        return super.getQueryString();
	    }
	     
	}
	
 @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle((HttpServletRequest)new XssHttpServletRequestWrapper(request), response, handler);
    }
}
