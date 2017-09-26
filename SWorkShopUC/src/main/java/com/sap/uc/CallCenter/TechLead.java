package com.sap.uc.CallCenter;

public class TechLead extends Employee implements ICallHandler{

	static boolean flag = false;
	
	ICallHandler chain;
	@Override
	public void setNextHandler(ICallHandler handler) {
		// TODO Auto-generated method stub
		this.chain = handler;
	}

	@Override
	public void handleRequest(Employee e) {
		// TODO Auto-generated method stub
		System.out.println("Inside TechLead handling request ");
		TechLead tl = new TechLead();
		tl.setCanHandle(true);
		tl.setFree(true);
		if(e.getType() == EmployeeType.TechnicalLead){
			if(tl.isCanHandle() || tl.isFree()){
				System.out.println("Call has been answered by the Fresher");
				flag = true;
			}else{
				this.chain.handleRequest(e);
			}
		}
		
	}
}
