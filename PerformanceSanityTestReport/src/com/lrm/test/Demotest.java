package com.lrm.test;

import java.util.LinkedList;
import java.util.List;

import com.lrm.factory.Factory;
import com.lrm.vo.IterationResult;

public class Demotest {
	public static void main(String[] args) {
		IterationResult iterationResult = new IterationResult();
		iterationResult.setResponseTime("12.234");
		iterationResult.setBackendTime("12.234");
		iterationResult.setNetworkTime("12.234");
		iterationResult.setPageKb("12.234");
		iterationResult.setStartTime("10:00:00");
		doCreate(iterationResult);
		doSearch(null);
		
		if (doSearch(null)!=null&&!doSearch(null).isEmpty()) {
			iterationResult = doSearch("").get(0);
			iterationResult.setResponseTime("88.88");
			doChange(iterationResult);
			doSearch("WHERE id = "+iterationResult.getResultId());
			
			doDelete(iterationResult.getResultId());
			doSearch(null);
		}
		
		
		
	}
	
	public static List<IterationResult>  doSearch(String keys) {
		List<IterationResult> allDemos = new LinkedList<IterationResult>();
		allDemos = Factory.getDemoDAOInstance().doSearch(keys);
		for (IterationResult iterationResult : allDemos) {
			System.out.println(iterationResult.toString());
		}
		return allDemos;
	}
	public static void  doCreate(IterationResult iterationResult) {
		if (Factory.getDemoDAOInstance().doCreate(iterationResult)) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
	public static void  doChange(IterationResult iterationResult) {
		if (Factory.getDemoDAOInstance().doChange(iterationResult)) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	public static void  doDelete(int id) {
		if (Factory.getDemoDAOInstance().doDelete(id)) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
}
/*
 * 输出结果
		添加成功
		SELECT id,name,type,pay,text FROM t_demo 
		demo [id=1, name=Name, type=1, pay=0.98, text=Text]
		SELECT id,name,type,pay,text FROM t_demo 
		demo [id=1, name=Name, type=1, pay=0.98, text=Text]
		SELECT id,name,type,pay,text FROM t_demo 
		demo [id=1, name=Name, type=1, pay=0.98, text=Text]
		SELECT id,name,type,pay,text FROM t_demo 
		demo [id=1, name=Name, type=1, pay=0.98, text=Text]
		修改成功
		SELECT id,name,type,pay,text FROM t_demo WHERE id = 1
		demo [id=1, name=Name, type=1, pay=0.98, text=Change Text]
		删除成功
		SELECT id,name,type,pay,text FROM t_demo 

 * */
