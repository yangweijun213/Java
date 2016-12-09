package com.perf.entity;

public class TestStep {
	
	private String stepName;
	private String startTime;
	private String averageTime;
	
	public TestStep() {

	}

	public TestStep(String stepName, String startTime, String averageTime) {

		this.stepName = stepName;
		this.startTime = startTime;
		this.averageTime = averageTime;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(String averageTime) {
		this.averageTime = averageTime;
	}

	
	

}
