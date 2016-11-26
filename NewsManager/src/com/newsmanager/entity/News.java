package com.newsmanager.entity;

import java.util.Date;


/**
 * ����  ���ű��Ӧ��ʵ����
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
	
	//�����޲ι��췽��
	public News() {
	}

	//�����вι��췽��
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
