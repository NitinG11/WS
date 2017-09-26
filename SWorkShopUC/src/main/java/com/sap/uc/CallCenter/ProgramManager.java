package com.sap.uc.CallCenter;

public class ProgramManager extends Employee implements ICallHandler {

	ICallHandler chain;
	@Override
	public void setNextHandler(ICallHandler handler) {
		// TODO Auto-generated method stub
		this.chain = (handler);
		
	}
	@Override
	public void handleRequest(Employee pm) {
		// TODO Auto-generated method stub
		System.out.println("Inside Progrma Manger handling request ");
		if(!pm.isFree() || !pm.isCanHandle())
			this.chain.handleRequest(pm);
	}

}
