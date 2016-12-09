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
 *  数据调用和处理 
 */
public class NewsServlet extends HttpServlet {
	
    private NewsDao newsDao;
	
    //重写方法init()
	@Override
	public void init() throws ServletException {
		//newsDao对象初始化
		newsDao = new NewsDao ();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pageNumber = 1;
		//接受page number
		String pn = request.getParameter("pageNumber");
		if (pn!=null){
			pageNumber = Integer.valueOf(pn);
		}
		if (pageNumber<=1){
			pageNumber =1;
		}
		int count = newsDao.getCount();
		Integer pageSize = 10;
		//总条数除以每页条数,如果0,取商,否则商+1
		int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1;
		if (pageNumber>pageCount) {
			pageNumber = pageCount;
		}
		
		//调用 查询新闻集合的方法
		List<News> newsList = newsDao.getNewsList(pageNumber, pageSize);
		//添加到request作用域 中，方便页面的调用
		request.setAttribute("newsList", newsList);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("pageCount", pageCount);
		//转发到newsList.jsp页面
		request.getRequestDispatcher("newsList.jsp").forward(request,response);
	}

}
