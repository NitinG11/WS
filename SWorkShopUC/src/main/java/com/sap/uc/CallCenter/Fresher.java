package com.sap.uc.CallCenter;

import java.util.ArrayList;
import java.util.List;

public class Fresher extends Employee implements ICallHandler{

	ICallHandler callHandle;
	static boolean flag = false;
	
	
	@Override
	public void setNextHandler(ICallHandler handler) {
		// TODO Auto-generated method stub
		this.callHandle = handler;
	}

	@Override
	public void handleRequest(Employee e) {
		// TODO Auto-generated method stub
		if(e.getType() == EmployeeType.Fresher){
			Fresher f = new Fresher();
			f.setCanHandle(false);
			f.setFree(false);
			
			Fresher f1 = new Fresher();
			f1.setCanHandle(true);
			f1.setFree(true);
			
			Fresher f2 = new Fresher();
			f2.setCanHandle(false);
			f2.setFree(false);
			
			List<Fresher> freshers = new ArrayList<Fresher>();
			freshers.add(f);
			freshers.add(f1);
			freshers.add(f2);
			
			for(Fresher fr : freshers) {
				if(fr.isCanHandle() || fr.isFree()){
					System.out.println("Call has been answered by the Fresher");
					flag = true;
					break;
				}
			}
			if(!flag)
				this.callHandle.handleRequest(e);
		}
//		this.callHandle.handleRequest(e);
	}
	

}
