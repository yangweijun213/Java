package cn.bjsxt.set;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import cn.bjsxt.list.NewsItem;
import cn.bjsxt.list.NewsItemClickCom;

/**
 * TreeSet:�������򣬲����ظ�  û�б�Ҫ��дhashcode��equals
 * ��������pojo+java.lang.Comparable
 *          ����+java.util.Comparator
 * �ظ�:����0 ��ʾ��ͬ
 * 
 * ����֮��:
 * POJO����дhashcode��equals +toString+ java.lang.Comparable
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
		news.add(new NewsItem(" ϰ��ƽ����Ա���ͨ�� ����|�Һ˹����������ɽ��",new Date(System.currentTimeMillis()-24*60*60*1000),800));
		news.add(new NewsItem(" ˹ŵ�ǵֶ� �����Ѷ�϶��",new Date(),200));
		news.add(new NewsItem(" ϰ��ƽ����Ա���ͨ�� ����|�Һ˹����������ɽ��",new Date(System.currentTimeMillis()-24*60*60*1000),800));
		// ���ڽ���
		for(NewsItem item:news){
			System.out.println(item);
		}
		
	}

}
