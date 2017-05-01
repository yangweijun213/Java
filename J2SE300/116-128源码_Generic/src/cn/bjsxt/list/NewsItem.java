package cn.bjsxt.list;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ��ҵ���������
 * @author Administrator
 *
 */
public class NewsItem implements java.lang.Comparable<NewsItem>{
	private String title;
	private Date publishDate;
	private int click;
	public NewsItem() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public NewsItem(String title, Date publishDate, int click) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.click = click;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}


	//��д�������  ���ڽ���
	/**
	 * ���� >
	 * ��  ==
	 * ���� <
	 */
	public int compareTo(NewsItem o) {
		if(null==o){
			return -5;
		}
		//Ĭ������
		int sorted =  this.publishDate.compareTo(o.publishDate);
		return -sorted;
	}
	
	
	
	
	@Override
	public String toString() {
		return "("+title+"\t"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.publishDate)+"\t"+this.click+")";
	}
	
	
	
}
