package cn.sxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * �Զ����Controller��Ҫʵ��Controller�ӿ�
 * */
public class HelloController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		//�����������д���
		System.out.println("-----hello controller-------"); 
		//����һ��ModelAndView����  �ö��������ͼ��Ⱦ����ȾΪָ����ͼ
		ModelAndView mv = new ModelAndView();
		//������ͼ���� ----������Ϊָ����ҳ��
		mv.setViewName("hello");
		//��ӽ������  �����ݿ�����ҳ����ͨ��el���ʽ��ȡ
		mv.addObject("msg", "first spring mvc app");
		return mv;
	}
}
