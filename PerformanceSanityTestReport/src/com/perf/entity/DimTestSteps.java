package com.perf.entity;

public class DimTestSteps {

	private Integer stepId;
	private String stepName;
	
	//�޲ι��캯��
	public DimTestSteps() {
	}
	
	//�вй��캯��
	public DimTestSteps(Integer stepId, String stepName) {
		this.stepId = stepId;
		this.stepName = stepName;
	}
	
	//getter, setter����
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
