package com.perf.entity;

public class Iterations {
	
	private Integer resultId;
	private String responseTime;
	private String backendTime;
	private String networkTime;
	private String pageKb;
	private String startTime;
	
	
	//�޲ι��캯��
	public Iterations() {
	}
	//�вй��캯��
	public Iterations( Integer resultId, String startTime, String responseTime, String backendTime, String networkTime,
			String pageKb) {
		this.resultId = resultId;
		this.startTime = startTime;
		this.responseTime = responseTime;
		this.backendTime = backendTime;
		this.networkTime = networkTime;
		this.pageKb = pageKb;
	}

	//getter, setter����
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public String getBackendTime() {
		return backendTime;
	}

	public void setBackendTime(String backendTime) {
		this.backendTime = backendTime;
	}

	public String getNetworkTime() {
		return networkTime;
	}

	public void setNetworkTime(String networkTime) {
		this.networkTime = networkTime;
	}
	public String getPageKb() {
		return pageKb;
	}
	public void setPageKb(String pageKb) {
		this.pageKb = pageKb;
	}
	
}
