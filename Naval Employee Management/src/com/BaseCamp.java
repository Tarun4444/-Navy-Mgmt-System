package com;

public class BaseCamp {
	private int baseCampId;
	private String baseCampName;
	private String baseCampLoc;
	public BaseCamp(int baseCampId, String baseCampName, String baseCampLoc) {
		super();
		this.baseCampId = baseCampId;
		this.baseCampName = baseCampName;
		this.baseCampLoc = baseCampLoc;
	}
	public int getBaseCampId() {
		return baseCampId;
	}
	public void setBaseCampId(int baseCampId) {
		this.baseCampId = baseCampId;
	}
	public String getBaseCampName() {
		return baseCampName;
	}
	public void setBaseCampName(String baseCampName) {
		this.baseCampName = baseCampName;
	}
	public String getBaseCampLoc() {
		return baseCampLoc;
	}
	public void setBaseCampLoc(String baseCampLoc) {
		this.baseCampLoc = baseCampLoc;
	}
	
	
}
