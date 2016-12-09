package com.perf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perf.dao.IterationsDao;
import com.perf.entity.Iterations;

/**
 *  ���ݵ��úʹ��� 
 */
public class IterationsServlet extends HttpServlet {
	
    private IterationsDao iterationsDao;
	
    //��д����init()
	@Override
	public void init() throws ServletException {
		//newsDao�����ʼ��
		iterationsDao = new IterationsDao ();
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
		int count = iterationsDao.getCount();
		Integer pageSize = 10;
		//����������ÿҳ����,���0,ȡ��,������+1
		int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1;
		if (pageNumber>pageCount) {
			pageNumber = pageCount;
		}
		
		//���� ��ѯ���ż��ϵķ���
		List<Iterations> iterationsList = iterationsDao.getIterationsList(pageNumber, pageSize);
		//��ӵ�request������ �У�����ҳ��ĵ���
		request.setAttribute("iterationsList", iterationsList);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("pageCount", pageCount);
		//ת����newsList.jspҳ��
		request.getRequestDispatcher("iterationsList.jsp").forward(request,response);
	}

}
