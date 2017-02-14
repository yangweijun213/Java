package cn.sxt.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * ��Controller�Ĵ�����֮ǰ��ִ�� ִ��һЩ��ʼ����Ȩ���жϣ���־�ȴ��� �������false ������ִ��Controller�еĴ�����
	 */

	// ������Щurl������,��Щ��Ҫ������
	private List<String> allowedPass;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ��¼������
		/*
		 * 1�ж�session���Ƿ���ֵ����ֵ-----���� 2session��û��ֵ ���ж������Ƿ���toLogin.do��login.do
		 * �����----���� 3����ת��toLogin.do
		 */

		// ȡ�����������url
		String url = request.getRequestURL().toString();

		// ���ж�session���Ƿ���
		Object user = request.getSession().getAttribute("user");
		// ���session�еĻ�,�Ͳ���ȥ������.
		if (user != null)
			return true;
		// ���û�еĻ�,��Ҫ����
		for (String temp : allowedPass) {
			// ���url��temp��β��,�ͱ�����,������
			if (url.endsWith(temp)) {
				return true;
			}
		}

		// ��ת��login.jsp
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		return false;

	}

	/**
	 * ��Controller������ִ��֮���ڱ���Ⱦ֮ǰ ִ�� �رգ��ͷţ�����һЩControllerִ������Ҫ����Դ
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * ����Ⱦ����Ⱦ��ִ�� ����һ��������һЩ����
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	//��Ҫ����set����
	public void setAllowedPass(List<String> allowedPass) {
		this.allowedPass = allowedPass;
	}
	
	
}
