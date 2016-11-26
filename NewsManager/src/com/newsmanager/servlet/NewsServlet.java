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
		
		//调用 查询新闻集合的方法
		List<News> newsList = newsDao.getNewsList();
		//添加到request作用域 中
		request.setAttribute("newsList", newsList);
		//转发到newsList.jsp页面
		request.getRequestDispatcher("newsList.jsp").forward(request,response);
	}

}
