package com.sap.uc.CallCenter;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	ICallHandler  callHandler;
	public static void main(String[] args) {
		
		MainClass m = new MainClass();
		
	}
	
	public MainClass() {
		// TODO Auto-generated constructor stub\
//		this.callHandler = 
		Employee e = new Fresher();
		this.callHandler.handleRequest(e);
		callHandler.setNextHandler(new TechLead());
//		this.callHandler = new TechLead();
		ProgramManager pm = new ProgramManager();
		callHandler.setNextHandler(pm);
	}
}
