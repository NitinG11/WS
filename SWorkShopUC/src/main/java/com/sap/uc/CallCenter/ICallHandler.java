package com.sap.uc.CallCenter;

public interface ICallHandler {

	public void setNextHandler(ICallHandler handler);
	
	public void handleRequest(Employee e);
	
}
