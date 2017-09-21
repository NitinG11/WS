package com.sap.WS.Discussions;

public class DriverHashMap {

	public static void main(String[] args) {
		CHashMap<String, String> hm = new CHashMap<>();
		hm.put("11", "112");
		hm.put("3s", "fd");
		hm.put("pk", "fd");
//		hm.put("iiuy", "fd");
		
		System.out.println(hm.get("pk"));
		
		
	}
}
