package com.perf.entity;

public class DimTestScripts {
	private Integer scriptId;
	private  String scriptName;

	//无参构造函数
	public DimTestScripts() {
	}

	//有残构造函数
	public DimTestScripts(Integer scriptId, String scriptName) {
		this.scriptId = scriptId;
		this.scriptName = scriptName;
	}

	//getter, setter方法
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
