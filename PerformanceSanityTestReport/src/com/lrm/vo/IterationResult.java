package com.lrm.vo;

public class IterationResult {
	private Integer resultId;
	private String responseTime;
	private String backendTime;
	private String networkTime;
	private String pageKb;
	private String startTime;
	
	public IterationResult() {
		// TODO Auto-generated constructor stub
	}
	
	public IterationResult( Integer resultId, String responseTime, String backendTime, String networkTime,
			String pageKb,String startTime) {
		this.resultId = resultId;
		this.responseTime = responseTime;
		this.backendTime = backendTime;
		this.networkTime = networkTime;
		this.pageKb = pageKb;
		this.startTime = startTime;
	}
	
	//getter, setter·½·¨
	
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
		
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

	@Override
	public String toString() {
		return "IterationResult [resultId=" + resultId + ", responseTime=" + responseTime + ", backendTime=" + backendTime
				+ ", networkTime=" + networkTime + ", pageKb=" + pageKb + ",startTime=" + startTime + "]";
	}
	
}
