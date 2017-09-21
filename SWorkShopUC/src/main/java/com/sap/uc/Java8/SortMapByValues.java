package com.sap.uc.Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.print.attribute.standard.PrinterLocation;

public class SortMapByValues {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("Dummy1", "Value1");
		map.put("Jeorge", "Bailey");
		map.put("Josh", "Blouch");
		map.put("Michael", "Vaughn");
		
		//sort Map using values using Java8
		Iterator<String> it =map.values().stream().sorted((v1,v2) -> v1.compareTo(v2)).iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		//technique 2
		Set<Entry<String,String>> oSet = map.entrySet();
		ArrayList<Entry<String, String>> oList = new ArrayList<>(oSet);
		System.out.println(oList.size());
		Collections.sort(oList,new MyComparator());
		System.out.println(oList.size());
		Iterator<Entry<String, String>> iter = oList.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		//technique 3
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(value -> System.out.println(value));
	}
}

class MyComparator implements Comparator<Map.Entry<String, String>> {

	@Override
	public int compare(Entry<String, String> o1, Entry<String, String> o2) {
		// TODO Auto-generated method stub
		return (o1.getValue().compareToIgnoreCase(o2.getValue()) >0) ? 1 :(o1.getValue().compareToIgnoreCase(o2.getValue()) < 0)?-1:0; 
//		return 0;
	}
	
}


