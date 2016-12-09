package com.lrm.dao;

import java.util.List;

import com.lrm.vo.TransactionResult;

public interface TransactionResultDAO {
	//≤È—Ø∑Ω∑®
	public List<TransactionResult> doSearch(String keys);
}