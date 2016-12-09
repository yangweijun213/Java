package com.lrm.dao;

import java.util.List;

import com.lrm.vo.IterationResult;

public interface IterationResultDAO {
	//添加方法
	public boolean doCreate(IterationResult iterationResult);
	//删除方法
	public boolean doDelete(int id);
	//修改方法
	public boolean doChange(IterationResult iterationResult);
	//查询方法
	public List<IterationResult> doSearch(String keys);
	
}