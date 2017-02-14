package cn.sxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	
	//在请求处理总的方法之前执行
	//如果返回true, 那么执行下一个拦截器,如果返回false,那么不执行下一个拦截器
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("==========处理前=============" );
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("==========处理后=============" );
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
