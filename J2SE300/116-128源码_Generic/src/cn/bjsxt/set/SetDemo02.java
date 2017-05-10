package cn.bjsxt.set;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import cn.bjsxt.list.NewsItem;
import cn.bjsxt.list.NewsItemClickCom;

/**
 * TreeSet:内容有序，不能重复  没有必要重写hashcode和equals
 * 内容有序：pojo+java.lang.Comparable
 *          规则+java.util.Comparator
 * 重复:等于0 表示相同
 * 
 * 万能之道:
 * POJO：重写hashcode和equals +toString+ java.lang.Comparable
 * 
 * 
 * @author Administrator
 *
 */
public class SetDemo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<NewsItem> news = new TreeSet<NewsItem>(new NewsItemClickCom());
		news.add(new NewsItem(" 习近平航天员天地通话 新闻|我核工厂深藏兰州山间",new Date(System.currentTimeMillis()-24*60*60*1000),800));
		news.add(new NewsItem(" 斯诺登抵俄 欲避难厄瓜多尔",new Date(),200));
		news.add(new NewsItem(" 习近平航天员天地通话 新闻|我核工厂深藏兰州山间",new Date(System.currentTimeMillis()-24*60*60*1000),800));
		// 日期降序
		for(NewsItem item:news){
			System.out.println(item);
		}
		
	}

}
