package com.newsmanager.entity;

import java.util.Date;


/**
 * 描述  新闻表对应的实体类
 * @author jeff yang
 *
 */
public class News {
	
	private Integer newsId;
	private String newsTitle;
	private String newsContent;
	private String newsStatus;
	private String newsType;
	private Date createTime;
	
	//创建无参构造方法
	public News() {
	}

	//创建有参构造方法
	public News(Integer newsId, String newsTitle, String newsContent, String newsStatus, String newsType,
			Date createTime) {
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsStatus = newsStatus;
		this.newsType = newsType;
		this.createTime = createTime;
	}
	
	//generate Getter and Setter
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsStatus() {
		return newsStatus;
	}
	public void setNewsStatus(String newsStatus) {
		this.newsStatus = newsStatus;
	}
	public String getNewsType() {
		return newsType;
	}
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
