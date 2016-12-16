package com.jqgrid.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** * Servlet implementation class JSONData */
public class JSONData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** * @see HttpServlet#HttpServlet() */
	public JSONData() {
		super();
		// TODO Auto-generated constructor stub }
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// JSONDataDemo.jsp
		String jsondata = "{\"page\":\"1\"," + " \"total\":2," + " \"records\":\"13\"," + " \"rows\":" + " [" + " {" + " \"id\":\"13\"," + " \"cell\":" + " [\"13\",\"2007-10-06\",\"Client 3\",\"1000.00\",\"0.00\",\"1000.00\",null]" + " }," + " {" + " \"id\":\"12\"," + " \"cell\":" + " [\"12\",\"2007-10-06\",\"Client 2\",\"700.00\",\"140.00\",\"840.00\",null]" + " }," + " {" + " \"id\":\"11\"," + " \"cell\":" + " [\"11\",\"2007-10-06\",\"Client 1\",\"600.00\",\"120.00\",\"720.00\",null]" + " }," + " {" + " \"id\":\"10\"," + " \"cell\":" + " [\"10\",\"2007-10-06\",\"Client 2\",\"100.00\",\"20.00\",\"120.00\",null]" + " }," + " {" + " \"id\":\"9\"," + " \"cell\":" + " [\"9\",\"2007-10-06\",\"Client 1\",\"200.00\",\"40.00\",\"240.00\",null]" + " }," + " {" + " \"id\":\"8\"," + " \"cell\":" + " [\"8\",\"2007-10-06\",\"Client 3\",\"200.00\",\"0.00\",\"200.00\",null]" + " }," + " {" + " \"id\":\"7\"," + " \"cell\":" + " [\"7\",\"2007-10-05\",\"Client 2\",\"120.00\",\"12.00\",\"134.00\",null]" + " }," + " {" + " \"id\":\"6\"," + " \"cell\":" + " [\"6\",\"2007-10-05\",\"Client 1\",\"50.00\",\"10.00\",\"60.00\",\"\"]" + " }," + " {" + " \"id\":\"5\"," + " \"cell\":" + " [\"5\",\"2007-10-05\",\"Client 3\",\"100.00\",\"0.00\",\"100.00\",\"no tax at all\"]" + " }," + " {" + " \"id\":\"4\"," + " \"cell\":" + " [\"4\",\"2007-10-04\",\"Client 3\",\"150.00\",\"0.00\",\"150.00\",\"no tax\"]" + " }" + " ]," + " \"userdata\":{\"amount\":3220,\"tax\":342,\"total\":3564,\"name\":\"Totals:\"}" + " }";
		//Pivot Grid: grouping rows - PivotGrid_GroupingRows.jsp
		String pivotJsonData = "{ \"rows\":[ { \"CategoryName\":\"Beverages\","+" \"ProductName\":\"Steeleye Stout\","+ "\"Country\":\"UK\","+" \"Price\":\"1008.0000\","+" \"Quantity\":\"65\" },"+"{ \"CategoryName\":\"Beverages\","+" \"ProductName\":\"Laughing Lumberjack Lager\","+" \"Country\":\"USA\","+" \"Price\":\"140.0000\","+" \"Quantity\":\"10\" }"+"]}"; 
		//Pivot Grid: 按日期分组显示 - PivotDemo2.jsp
		String pivotJsonData2 = "{ \"rows\":[ { \"transactionName\":\"transaction_01\","+" \"startTime\":\"2016/11/23\","+ "\"averageTime\":\"11.16\" },"+"{ \"transactionName\":\"transaction_02\","+" \"startTime\":\"2016/11/23\","+ "\"averageTime\":\"10.61\" },"+"{ \"transactionName\":\"transaction_01\","+" \"startTime\":\"2016/11/24\","+ "\"averageTime\":\"10.385\" },"+"{ \"transactionName\":\"transaction_02\","+" \"startTime\":\"2016/11/24\","+ "\"averageTime\":\"10.87\" },"+"{ \"transactionName\":\"transaction_01\","+" \"startTime\":\"2016/11/25\","+ "\"averageTime\":\"10.625\" },"+"{ \"transactionName\":\"transaction_02\","+" \"startTime\":\"2016/11/25\","+ "\"averageTime\":\"14.22\" } "+"]}"; 
		//Pivot Grid: Column groups - PivotGrid_TotalsByColumnsAndRows
		String pivotJsonData3 = "{ \"rows\":[ { \"CategoryName\":\"Beverages\","+" \"ProductName\":\"Steeleye Stout\","+ "\"Country\":\"UK\","+" \"Price\":\"1008.0000\","+" \"Quantity\":\"65\" },"+"{ \"CategoryName\":\"Beverages\","+" \"ProductName\":\"Laughing Lumberjack Lager\","+" \"Country\":\"USA\","+" \"Price\":\"140.0000\","+" \"Quantity\":\"10\" }"+"]}"; 
		
		resp.getWriter().write(pivotJsonData2);
		 System.out.println(pivotJsonData2);
	
	}
	 /** 
	  * * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
	  * */
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // TODO Auto-generated method stub
		 
		 this.doGet(request, response);
	 }
}