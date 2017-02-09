package cn.sxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	
	//���������ܵķ���֮ǰִ��
	//�������true, ��ôִ����һ��������,�������false,��ô��ִ����һ��������
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("==========����ǰ=============" );
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("==========�����=============" );
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
