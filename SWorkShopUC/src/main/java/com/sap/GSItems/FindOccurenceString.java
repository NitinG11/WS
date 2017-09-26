package com.sap.GSItems;

public class FindOccurenceString {

	public static void main(String[] args) {
		String st= "SSSSSTTPP";
		int counter =1;
		for(int i = 1;i<st.length();i++){
			for(int j=i;j<i+1;j++){
				if(st.charAt(j) == st.charAt(j-1)){
					counter++;
					continue;
				}else{
					System.out.print(counter+""+st.charAt(j-1));
					counter =1;
				}
			
			}
		}
		System.out.print(counter+""+st.charAt(st.length()-1));
		
		method2(new StringBuffer(st));
	}
	
	static void method2(StringBuffer st) {
		
		int index =0;
		String res = "";
		while(st.length()!=0) {
			int count =0;
			char c = st.charAt(0);
			while(st.indexOf(c+"")> -1) {
				st.deleteCharAt(index);
				count ++;
			}
			res=res+count+c;
			
		}
		System.out.println(res);
	}
}
