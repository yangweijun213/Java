package com.lrm.vo;

public class TransactionResult {
	
	private String transactionName;
	private String startTime;
	private String averageResponseTime;
	
	
	public TransactionResult() {

	}

	public TransactionResult(String transactionName, String startTime, String averageResponseTime) {

		this.transactionName = transactionName;
		this.startTime = startTime;
		this.averageResponseTime = averageResponseTime;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getAverageResponseTime() {
		return averageResponseTime;
	}

	public void setAverageResponseTime(String averageResponseTime) {
		this.averageResponseTime = averageResponseTime;
	}
	
	@Override
	public String toString() {
		return "TransactionResult [transactionName=" + transactionName + ", startTime=" + startTime + ", averageResponseTime=" + averageResponseTime
				+ "]";
	}
}
