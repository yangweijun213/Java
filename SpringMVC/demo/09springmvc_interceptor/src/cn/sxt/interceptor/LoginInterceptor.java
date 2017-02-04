package cn.sxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 在Controller的处理方法之前被执行
	 * 执行一些初始化，权限判断，日志等处理
	 * 如果返回false 将不会执行Controller中的处理方法
	 * */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object object) throws Exception {
		//登录拦截器
		/*1判断session中是否有值，有值-----放行
		 *2session中没有值 ，判断请求是否是toLogin.do和login.do 如果是----放行
		 *3、跳转到toLogin.do
		 * */
		HttpSession session = req.getSession();
		if(session.getAttribute("user")!=null)
			return true;
		String path=req.getRequestURI();
		if(path.endsWith("toLogin.do")||path.endsWith("login.do"))
			return true;
		resp.sendRedirect("toLogin.do");
		return false;
	}
	/**
	 * 在Controller处理方法执行之后，在被渲染之前 执行
	 * 关闭，释放，处理一些Controller执行中需要的资源
	 * */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在渲染器渲染后被执行
	 * 处理一个请求后的一些清理
	 * */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	
	}

	
}
