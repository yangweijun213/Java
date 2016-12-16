package com.xeonmic.test;

import java.util.List;

import com.xeonmic.factory.Factory;
import com.xeonmic.vo.goodlist;

public class goodlisttest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<goodlist> all = null;
		all = Factory.getGoodListDAOInstance().doSearch(null);
		if (all!=null) {
			for (goodlist goodlist : all) {
				System.out.println(goodlist.toString());
			}
		}
	}

}
