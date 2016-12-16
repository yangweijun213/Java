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

		request.setCharacterEncoding("utf-8");  //���ﲻ���ñ����������
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");  
		int rows = Integer.valueOf(request.getParameter("rows")); //ÿҳ����ʾ�ļ�¼����
		int page = Integer.valueOf(request.getParameter("page")); //��ǰ��ҳ��
		String sord = request.getParameter("sord");//����ʽ
		String sidx = request.getParameter("sidx");//��������
		Boolean search =(request.getParameter("_search").equals("true"))?true:false;//�Ƿ����ڲ�ѯ����
		List<goodlist> allList = new LinkedList<goodlist>();//���ؽ����
		
		if (request.getParameter("id")!=null &&!"".equals(request.getParameter("id"))) {
			int id = Integer.valueOf(request.getParameter("id"));
			String keys=" WHERE  id = "+id+" ";//��ѯ�����ַ���
			if(search ){
				
				String filters = request.getParameter("filters");//���������
				if (filters!=null&&!"".equals(filters)) {
					keys += " AND ( ";//���ӱ�����ļ���������AND������1 AND ����2 OR ����3...������ʽ��װ
					System.out.println("filters="+filters);
					//�������ݵĸ�ʽ�����������ģ�"{"groupOp":"AND","rules":[{"field":"id","op":"eq","data":"1"},{"field":"type","op":"ew","data":"2"}]}"
					JSONObject jsonObject = JSONObject.fromObject(filters);
					String groupOp = "AND";//ÿ������֮��Ĺ�ϵ��and/or��
					if (jsonObject.getString("groupOp")!=null&&!"".equals(jsonObject.getString("groupOp"))) {
						if (jsonObject.getString("groupOp").equals("OR")) {
							groupOp = "OR";
						}
					}
					
					JSONArray rulesjson = jsonObject.getJSONArray("rules");
					//����ÿ������
					for (int z=0; z < rulesjson.size(); z++) {
						Object t = rulesjson.get(z);
						JSONObject rulejson = JSONObject.fromObject(t);
						String field = rulejson.getString("field");
						String op = rulejson.getString("op");
						String data = rulejson.getString("data");
						String string = "";//���ڴ洢��������sql���Ƭ��
						//��ʼת��Ϊsql���
						switch (op) {
						case "eq"://���
							string=" = '"+data+"' ";
							break;
						case "ne"://�����
							string=" <> '"+data+"' ";
							break;
						case "li"://С��
							string=" < '"+data+"' ";
							break;
						case"le"://С�ڵ���
							string=" <= '"+data+"' ";
							break;
						case"gt"://����
							string=" > '"+data+"' ";
							break;
						case "ge"://���ڵ���
							string=" >= '"+data+"' ";
							break;
						case "bw"://��...֮��
							{
								if (data.split(",").length==2) {
									string=" BETWEEN '"+data.split(",")[0]+"' AND '"+data.split(",")[1]+"' ";
								}else {
									string=" = '"+data+"' ";//���ݴ���ʱ����
								}
							}	
							
							break;
						case"bn"://����...֮��
							{
								if (data.split(",").length==2) {
									string=" NOT BETWEEN '"+data.split(",")[0]+"' AND '"+data.split(",")[1]+"' ";
								}else {
									string=" <> '"+data+"' ";//���ݴ���ʱ����
								}
							}
							break;
						case"ew"://��...����
							string=" LIKE '%"+data+"' ";
							break;
						case "en"://����...����
							string=" NOT LIKE '%"+data+"' ";
							break;
						case "cn"://����
							string=" LIKE '%"+data+"%' ";
							break;
						case "nc"://������
							string=" NOT LIKE '%"+data+"%' ";
							break;
						case "in"://��
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
						case "ni"://����
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
							System.out.println("OP���Ŵ���");//OP���Ŵ���
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
			//������SQL���ת��
			if (sidx!=null&&!"".equals(sidx)) {
				System.out.println(sidx);
				keys += " ORDER BY " + sidx;
				System.out.println("sord="+sord);
				if (!sord.equals("asc")) {
					keys += " DESC ";
				}
			}
			
			allList = Factory.getGoodListDAOInstance().doSearch(keys);
			//��ҳ����
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
			//�����������ҳ��Ϣ��װ ����
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
