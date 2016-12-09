package com.lrm.dao;

import java.util.List;

import com.lrm.vo.IterationResult;

public interface IterationResultDAO {
	//��ӷ���
	public boolean doCreate(IterationResult iterationResult);
	//ɾ������
	public boolean doDelete(int id);
	//�޸ķ���
	public boolean doChange(IterationResult iterationResult);
	//��ѯ����
	public List<IterationResult> doSearch(String keys);
	
}