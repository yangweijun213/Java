package com.perf.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perf.dao.TestStepDao;
import com.perf.entity.TestStep;

/**
 *  ���ݵ��úʹ��� 
 */
public class TestStepServlet extends HttpServlet {
	
    private TestStepDao testStepDao;
	
    //��д����init()
	@Override
	public void init() throws ServletException {
		//newsDao�����ʼ��
		testStepDao = new TestStepDao ();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pageNumber = 1;
		//����page number
		String pn = request.getParameter("pageNumber");
		if (pn!=null){
			pageNumber = Integer.valueOf(pn);
		}
		if (pageNumber<=1){
			pageNumber =1;
		}
		int count = testStepDao.getCount();
		Integer pageSize = 10;
		//����������ÿҳ����,���0,ȡ��,������+1
		int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1;
		if (pageNumber>pageCount) {
			pageNumber = pageCount;
		}
		
		//���� ��ѯ���ż��ϵķ���

		List<TestStep> testStepList = testStepDao.getTestStepList(pageNumber, pageSize);
		
		//��ӵ�request������ �У�����ҳ��ĵ���
		request.setAttribute("testStepList", testStepList);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("pageCount", pageCount);
		//ת����newsList.jspҳ��
		request.getRequestDispatcher("testStepList.jsp").forward(request,response);
	}

}
