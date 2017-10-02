package com.sap.GSItems;

import java.util.HashMap;

public class FirstUnique {

	public static void main(String[] args) {
		String st = "aabcdde";
		findFirstUnique(st);
		findKthUnique(st,4);
	}
	
	static void findFirstUnique(String st) {
		HashMap<Character,Integer> map  = new HashMap<Character,Integer>();
		for(int i=0;i<st.length();i++) {
			if(map.containsKey(st.charAt(i))){
				map.put(st.charAt(i), map.get(st.charAt(i))+1);
			}else
				map.put(st.charAt(i), 1);
		}
		
		for(int i=0;i<st.length();i++) {
			if(map.get(st.charAt(i))>1) {
				System.out.println("Occurence of char is more than once");
			}else {
				System.out.println("First Unique character in the string is "+st.charAt(i));
				return;
			}
		}
	}
	
	static void findKthUnique(String st, int index) {
		int temp = index;
		HashMap<Character,Integer> map  = new HashMap<Character,Integer>();
		for(int i=0;i<st.length();i++) {
			if(map.containsKey(st.charAt(i))){
				map.put(st.charAt(i), map.get(st.charAt(i))+1);
			}else
				map.put(st.charAt(i), 1);
		}
		
		for(int i=0;i<st.length();i++) {
			if(map.get(st.charAt(i))>1) {
			}else {
				if(--index == 0)
				{
					System.out.println(temp+" Unique character in the string is "+st.charAt(i));
					return;
				}else{
					System.out.println("Searching outside boundary condition");
					return;
				}
			}
		}
	}
}
