package com.perf.entity;

import java.util.Date;

public class DimTestRun {
	private Integer runId;
	private Date startTime;
	private Date endTime;
	
	//无参构造函数
	public DimTestRun() {
	}
	
	//有残构造函数
	public DimTestRun(Integer runId, Date startTime, Date endTime) {
		this.runId = runId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	//getter, setter方法
	public Integer getRunId() {
		return runId;
	}
	public void setRunId(Integer runId) {
		this.runId = runId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
}
