package com.newsmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newsmanager.dao.NewsDao;
import com.newsmanager.entity.News;

/**
 *  ���ݵ��úʹ��� 
 */
public class NewsServlet extends HttpServlet {
	
    private NewsDao newsDao;
	
    //��д����init()
	@Override
	public void init() throws ServletException {
		//newsDao�����ʼ��
		newsDao = new NewsDao ();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���� ��ѯ���ż��ϵķ���
		List<News> newsList = newsDao.getNewsList();
		//��ӵ�request������ ��
		request.setAttribute("newsList", newsList);
		//ת����newsList.jspҳ��
		request.getRequestDispatcher("newsList.jsp").forward(request,response);
	}

}
