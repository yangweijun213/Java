package com.xeonmic.dao;

import java.util.List;

import com.xeonmic.vo.goodlist;

public interface GoodListDAO {
	//≤È—Ø∑Ω∑®
	public List<goodlist> doSearch(String keys);
}
