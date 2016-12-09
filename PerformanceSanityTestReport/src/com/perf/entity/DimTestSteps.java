package com.perf.entity;

public class DimTestSteps {

	private Integer stepId;
	private String stepName;
	
	//无参构造函数
	public DimTestSteps() {
	}
	
	//有残构造函数
	public DimTestSteps(Integer stepId, String stepName) {
		this.stepId = stepId;
		this.stepName = stepName;
	}
	
	//getter, setter方法
	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	
	
	
	
}
