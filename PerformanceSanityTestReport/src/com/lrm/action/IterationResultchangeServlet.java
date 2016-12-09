package com.lrm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lrm.factory.Factory;
import com.lrm.vo.IterationResult;

public class IterationResultchangeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean flag = false;
		String oper =request.getParameter("oper");
		switch (oper) {
			case "del":
				{
					String[] ids = request.getParameter("id").split(",");
					for (int i = 0; i < ids.length; i++) {
						int id =Integer.valueOf(ids[i]);
						flag=Factory.getDemoDAOInstance().doDelete(id);
					}
					
				}			
				break;
			case "add":
				{
					//int type = Integer.valueOf(request.getParameter("type"));
					//Double pay = Double.valueOf(request.getParameter("pay"));
					String response_time = request.getParameter("response_time");
					String backend_time = request.getParameter("backend_time");
					String network_time = request.getParameter("network_time");
					String pagesize = request.getParameter("pagesize");
					String start_time = request.getParameter("start_time");
					IterationResult iterationResult = new IterationResult(-1,response_time,backend_time,network_time,pagesize,start_time);
					flag = Factory.getDemoDAOInstance().doCreate(iterationResult);							
				}
				break;
			case "edit":
				{
					int result_id = Integer.valueOf(request.getParameter("result_id"));
					//int type = Integer.valueOf(request.getParameter("type"));
					//Double pay = Double.valueOf(request.getParameter("pay"));
					String response_time = request.getParameter("response_time");
					String backend_time = request.getParameter("backend_time");
					String network_time = request.getParameter("network_time");
					String pagesize = request.getParameter("pagesize");
					String start_time = request.getParameter("start_time");
					IterationResult iterationResult = new IterationResult(result_id,response_time,backend_time,network_time,pagesize,start_time);
					flag = Factory.getDemoDAOInstance().doChange(iterationResult);							
				}
				break;

			default:
				break;
		}
		System.out.println(flag);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
