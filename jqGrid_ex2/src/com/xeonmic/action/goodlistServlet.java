package com.xeonmic.action;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.xeonmic.factory.Factory;
import com.xeonmic.vo.goodlist;

public class goodlistServlet extends HttpServlet {

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

		request.setCharacterEncoding("utf-8");  //这里不设置编码会有乱码
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");  
		int rows = Integer.valueOf(request.getParameter("rows")); //每页中显示的记录行数
		int page = Integer.valueOf(request.getParameter("page")); //当前的页码
		String sord = request.getParameter("sord");//排序方式
		String sidx = request.getParameter("sidx");//排序列名
		Boolean search =(request.getParameter("_search").equals("true"))?true:false;//是否用于查询请求
		List<goodlist> allList = new LinkedList<goodlist>();//返回结果集
		
		if (request.getParameter("id")!=null &&!"".equals(request.getParameter("id"))) {
			int id = Integer.valueOf(request.getParameter("id"));
			String keys=" WHERE  id = "+id+" ";//查询条件字符串
			if(search ){
				
				String filters = request.getParameter("filters");//具体的条件
				if (filters!=null&&!"".equals(filters)) {
					keys += " AND ( ";//将从表自身的检索条件用AND（条件1 AND 条件2 OR 条件3...）的形式封装
					System.out.println("filters="+filters);
					//传入数据的格式是类似这样的："{"groupOp":"AND","rules":[{"field":"id","op":"eq","data":"1"},{"field":"type","op":"ew","data":"2"}]}"
					JSONObject jsonObject = JSONObject.fromObject(filters);
					String groupOp = "AND";//每个规则之间的关系（and/or）
					if (jsonObject.getString("groupOp")!=null&&!"".equals(jsonObject.getString("groupOp"))) {
						if (jsonObject.getString("groupOp").equals("OR")) {
							groupOp = "OR";
						}
					}
					
					JSONArray rulesjson = jsonObject.getJSONArray("rules");
					//遍历每个条件
					for (int z=0; z < rulesjson.size(); z++) {
						Object t = rulesjson.get(z);
						JSONObject rulejson = JSONObject.fromObject(t);
						String field = rulejson.getString("field");
						String op = rulejson.getString("op");
						String data = rulejson.getString("data");
						String string = "";//用于存储单个条件sql语句片段
						//开始转化为sql语句
						switch (op) {
						case "eq"://相等
							string=" = '"+data+"' ";
							break;
						case "ne"://不相等
							string=" <> '"+data+"' ";
							break;
						case "li"://小于
							string=" < '"+data+"' ";
							break;
						case"le"://小于等于
							string=" <= '"+data+"' ";
							break;
						case"gt"://大于
							string=" > '"+data+"' ";
							break;
						case "ge"://大于等于
							string=" >= '"+data+"' ";
							break;
						case "bw"://在...之间
							{
								if (data.split(",").length==2) {
									string=" BETWEEN '"+data.split(",")[0]+"' AND '"+data.split(",")[1]+"' ";
								}else {
									string=" = '"+data+"' ";//数据错误时处理
								}
							}	
							
							break;
						case"bn"://不在...之间
							{
								if (data.split(",").length==2) {
									string=" NOT BETWEEN '"+data.split(",")[0]+"' AND '"+data.split(",")[1]+"' ";
								}else {
									string=" <> '"+data+"' ";//数据错误时处理
								}
							}
							break;
						case"ew"://以...结束
							string=" LIKE '%"+data+"' ";
							break;
						case "en"://不以...结束
							string=" NOT LIKE '%"+data+"' ";
							break;
						case "cn"://包含
							string=" LIKE '%"+data+"%' ";
							break;
						case "nc"://不包含
							string=" NOT LIKE '%"+data+"%' ";
							break;
						case "in"://在
							{
								string=" IN ( ";
								String[] datas = data.split(",");
								for (int i = 0; i < datas.length; i++) {
									string+= " '"+datas[i]+"' ";
									if (i!=datas.length-1) {
										string += ",";
									}else {
										string += " ) ";
									}
								}
							}
							break;
						case "ni"://不在
							{
								string=" NOT IN ( ";
								String[] datas = data.split(",");
								for (int i = 0; i < datas.length; i++) {
									string+= " '"+datas[i]+"' ";
									if (i!=datas.length-1) {
										string += ",";
									}else {
										string += " ) ";
									}
								}
							}
							break;
						default:
							op=null;
							System.out.println("OP符号错误");//OP符号错误
						}
						if (op!=null) {
							if (z==rulesjson.size()-1) {
								keys+=" "+field+" "+string +" ";
							}else {
								keys+=" "+field+" "+string +" "+groupOp+" ";
							}
							
						}
					}
					keys += "  ) ";
				}
				
			}
			//升降序SQL语句转换
			if (sidx!=null&&!"".equals(sidx)) {
				System.out.println(sidx);
				keys += " ORDER BY " + sidx;
				System.out.println("sord="+sord);
				if (!sord.equals("asc")) {
					keys += " DESC ";
				}
			}
			
			allList = Factory.getGoodListDAOInstance().doSearch(keys);
			//分页部分
			int total=0;	
			total=(allList.size()%rows==0)?(allList.size()/rows):((allList.size()/rows)+1);
			int j = 0;
			int m = (page-1)*rows;
			int n  =  (page-1)*rows+rows;
			JSONArray jArray = new JSONArray();
			for (j=m; j<allList.size()&&j<n; j++) {		
					jArray.add(JSONObject.fromObject(allList.get(j)));				
			}
			
			JSONObject jjson = new JSONObject();		
			//检索结果及分页信息封装 返回
			jjson.accumulate("page", page);
			jjson.accumulate("total", total);
			jjson.accumulate("records", allList.size());
			jjson.accumulate("rows", jArray);
			System.out.println(jjson.toString());
			response.getWriter().write(jjson.toString());
		}else {
			response.getWriter().write("{}");
		}
		
		
		
		
		
		
		
		
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
