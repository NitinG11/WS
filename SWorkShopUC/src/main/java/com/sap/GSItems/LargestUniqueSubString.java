package com.sap.GSItems;

import java.util.ArrayList;
import java.util.List;

public class LargestUniqueSubString {

	public static void main(String[] args) {
		String st = "aaabcbdeaf";
		findLongestUniqueSubStr(st);
	}
	
	static void findLongestUniqueSubStr(String st) {
		List<Character> list = new ArrayList<>();
		for(int i=0;i<st.length();i++) {
			if(list.contains(st.charAt(i))) {
				
			}
		}
	}
}
