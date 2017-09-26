package com.sap.uc.CallCenter;

import java.util.List;

public class Employee {

	private boolean isFree;
	private boolean canHandle;
	
	private ProgramManager pm;
	private TechLead tl;
	private List<Fresher> freshers;
	
	private EmployeeType type;
	
	
	
	public boolean isFree() {
		return isFree;
	}
	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	public boolean isCanHandle() {
		return canHandle;
	}
	public void setCanHandle(boolean canHandle) {
		this.canHandle = canHandle;
	}
	public ProgramManager getPm() {
		return pm;
	}
	public void setPm(ProgramManager pm) {
		this.pm = pm;
	}
	public TechLead getTl() {
		return tl;
	}
	public void setTl(TechLead tl) {
		this.tl = tl;
	}
	public List<Fresher> getFreshers() {
		return freshers;
	}
	public void setFreshers(List<Fresher> freshers) {
		this.freshers = freshers;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	
	
	
}

enum EmployeeType {
	Fresher, TechnicalLead, ProgramManager
}
