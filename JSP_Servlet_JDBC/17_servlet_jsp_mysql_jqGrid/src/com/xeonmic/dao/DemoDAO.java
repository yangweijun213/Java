package com.xeonmic.dao;

import java.util.List;
import com.xeonmic.vo.demo;

public interface DemoDAO {
	//��ӷ���
	public boolean doCreate(demo demo);
	//ɾ������
	public boolean doDelete(int id);
	//�޸ķ���
	public boolean doChange(demo demo);
	//��ѯ����
	public List<demo> doSearch(String keys);
}