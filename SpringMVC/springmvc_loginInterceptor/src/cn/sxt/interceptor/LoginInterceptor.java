package cn.sxt.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 在Controller的处理方法之前被执行 执行一些初始化，权限判断，日志等处理 如果返回false 将不会执行Controller中的处理方法
	 */

	// 允许哪些url被拦截,哪些需要被拦截
	private List<String> allowedPass;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 登录拦截器
		/*
		 * 1判断session中是否有值，有值-----放行 2session中没有值 ，判断请求是否是toLogin.do和login.do
		 * 如果是----放行 3、跳转到toLogin.do
		 */

		// 取得所有请求的url
		String url = request.getRequestURL().toString();

		// 先判断session中是否有
		Object user = request.getSession().getAttribute("user");
		// 如果session有的话,就不用去拦截了.
		if (user != null)
			return true;
		// 如果没有的话,需要拦截
		for (String temp : allowedPass) {
			// 如果url是temp结尾的,就被拦截,返回了
			if (url.endsWith(temp)) {
				return true;
			}
		}

		// 跳转到login.jsp
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		return false;

	}

	/**
	 * 在Controller处理方法执行之后，在被渲染之前 执行 关闭，释放，处理一些Controller执行中需要的资源
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 在渲染器渲染后被执行 处理一个请求后的一些清理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	//需要设置set方法
	public void setAllowedPass(List<String> allowedPass) {
		this.allowedPass = allowedPass;
	}
	
	
}
