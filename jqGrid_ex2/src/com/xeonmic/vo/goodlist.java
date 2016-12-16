package com.xeonmic.vo;

public class goodlist {
	private int id;
	private int g_id;
	private String g_name;
	private int g_type;
	private int d_num;
	public goodlist(int id, int g_id, String g_name, int g_type, int d_num) {
		super();
		this.id = id;
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_type = g_type;
		this.d_num = d_num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public int getG_type() {
		return g_type;
	}
	public void setG_type(int g_type) {
		this.g_type = g_type;
	}
	public int getD_num() {
		return d_num;
	}
	public void setD_num(int d_num) {
		this.d_num = d_num;
	}
	@Override
	public String toString() {
		return "goodlist [id=" + id + ", g_id=" + g_id + ", g_name=" + g_name
				+ ", g_type=" + g_type + ", d_num=" + d_num + "]";
	}
	
	
}
