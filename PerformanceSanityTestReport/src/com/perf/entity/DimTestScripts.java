package com.perf.entity;

public class DimTestScripts {
	private Integer scriptId;
	private  String scriptName;

	//�޲ι��캯��
	public DimTestScripts() {
	}

	//�вй��캯��
	public DimTestScripts(Integer scriptId, String scriptName) {
		this.scriptId = scriptId;
		this.scriptName = scriptName;
	}

	//getter, setter����
	public Integer getScriptId() {
		return scriptId;
	}

	public void setScriptId(Integer scriptId) {
		this.scriptId = scriptId;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}
	


}
