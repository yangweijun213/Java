package com.perf.entity;

import java.util.Date;

public class DimTestRun {
	private Integer runId;
	private Date startTime;
	private Date endTime;
	
	//�޲ι��캯��
	public DimTestRun() {
	}
	
	//�вй��캯��
	public DimTestRun(Integer runId, Date startTime, Date endTime) {
		this.runId = runId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	//getter, setter����
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
